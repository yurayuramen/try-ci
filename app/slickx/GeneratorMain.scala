package slickx

import slick.codegen.SourceCodeGenerator
import slick.jdbc.meta.MTable
import slick.driver.MySQLDriver
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import java.net.URI
import scala.concurrent.Await
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration
import slick.model.Model
import javax.swing.table.TableModel
import slick.model.Table

object GeneratorMain extends App 
{
  
  case class Settings(slickDriver:String,jdbcDriver:String,jdbcURL:String,jdbcUserID:String,jdbcPassword:String,outputDirectory:String,packageName:String,rootTraitName:String,scalaFileName:String,targetTables:Option[Seq[String]]) 
  
  def buildSettings()=
  {
  	val slickDriver="slick.driver.MySQLDriver"
  	val jdbcDriver="com.mysql.jdbc.Driver"
  	
  	val outputDir="./app"
  	
  	val url="jdbc:mysql://localhost/hello_active_adm_development"
  	val user=("root")
  	val password=("passwd")
  	
  	val pkg="model"
    val tableNames:Option[Seq[String]]=None //Some(Seq("cache"))
  	val topTraitName="HelloActiveAdm"
  	val scalaFileName="HelloActiveAdm.scala"
    
  	Settings(slickDriver=slickDriver,jdbcDriver=jdbcDriver,jdbcURL=url,jdbcUserID=user,jdbcPassword=password,outputDirectory=outputDir,packageName=pkg,rootTraitName=topTraitName,scalaFileName=scalaFileName,targetTables=tableNames)
  }
  
  
  val settings=buildSettings()
	
	
	/***
	 * 
	 * http://qiita.com/FScoward/items/4172def0e7cf28733c2e
	 * http://qiita.com/naoto1222/items/328108676e690bba7be1
	 * 
	 * 
	 * http://qiita.com/uedashuhei/items/25d5a6e786075729d3b3
	 * http://krrrr38.github.io/slick-doc-ja/v3.0.out/%E3%82%B9%E3%82%AD%E3%83%BC%E3%83%9E%E3%82%B3%E3%83%BC%E3%83%89%E3%81%AE%E7%94%9F%E6%88%90.html
	 * 
	 */
	class SourceCodeGeneratorEx(model:Model) extends SourceCodeGenerator(model)
	{
		override def Table = new Table(_){
			//auto_incrementを識別できるようにする
			//生成されるモデルはOption型になる
			override def autoIncLastAsOption=true
			override def Column=new Column(_)
			{
				override def rawType=model.tpe match
				{
					case "java.sql.Blob"=>
						"Array[Byte]"
					case _=>
						super.rawType
				}
			}
		}
		
		/*
		  // マッピングするテーブルとクラス名をオーバーライド
		  override def entityName =
		    dbTableName => dbTableName.dropRight(1).toLowerCase.toCamelCase
		  override def tableName =
		    dbTableName => dbTableName.toLowerCase.toCamelCase
		  // いくつか追加のimportを加える
		  override def code = "import foo.{MyCustomType,MyCustomTypeMapper}" + "\n" + super.code
		  // テーブルジェネレータをカスタマイズ
		  override def Table = new Table(_){
		    // エンティティクラスの生成を抑制する
		    override def EntityType = new EntityType{
		      override def classEnabled = false
		    }
		    // カラムジェネレータをカスタマイズ
		    override def Column = new Column(_){
		      // 特定のカラムに対して、Scalaの型を変更するようカスタマイズ
		      // e.g. to a custom enum or anything else
		      override def rawType =
		        if(model.name == "SOME_SPECIAL_COLUMN_NAME") "MyCustomType" else super.rawType
		    }
		  }
		*/
	}
	
	def run(slickDriver: String, jdbcDriver: String, url: String, outputDir: String, pkg: String, user: Option[String], password: Option[String],tableName:Option[String]): Unit = {
	  	
		//val model=MySQLDriver.createModel(Some(MySQLDriver.defaultTables))
		
		val model=tableName.flatMap { tableName => Some(MTable.getTables(tableName)) }
	    val driver: JdbcProfile =
	      Class.forName(slickDriver + "$").getField("MODULE$").get(null).asInstanceOf[JdbcProfile]
	    val dbFactory = driver.api.Database
	    val db = dbFactory.forURL(url, driver = jdbcDriver,
	      user = user.getOrElse(null), password = password.getOrElse(null), keepAliveConnection = true)
	    try {
	      //val m = Await.result(db.run(driver.createModel(None, false)(ExecutionContext.global).withPinnedSession), Duration.Inf)
	      val m = Await.result(db.run(driver.createModel(model, false)(ExecutionContext.global).withPinnedSession), Duration.Inf)
	      new SourceCodeGeneratorEx(m).writeToFile(slickDriver,outputDir,pkg)
	    } finally db.close
  	}
  	
	
	//this.run(slickDriver, jdbcDriver, url, outputDir, pkg, user, password, tableName)
	
	//SourceCodeGenerator.main(Array(slickDriver,jdbcDriver,url,outputDir,pkg,user.get,password.get))
	val driver: JdbcProfile = slick.driver.MySQLDriver
	val db = { slick.driver.MySQLDriver.api.Database.forURL(settings.jdbcURL, driver = settings.jdbcDriver, user = settings.jdbcUserID, password = settings.jdbcPassword) }
	//データベースよりテーブル情報を一式取得
	val model = Await.result(db.run(driver.createModel(None, false)(ExecutionContext.global).withPinnedSession), Duration.Inf)
	
	//slick-modelとして適用したいテーブルに限定してフィルタリング（絞り込み）
	val modelFiltered=settings.targetTables.
	//Noneが指定された場合、対象スキーマ（=database）の全テーブルを対象にする
	fold (model)
	//Someが指定された場合指定されたリストにあるテーブルに限定(絞り込み)を仕掛ける
	{tableNames=>
		Model(tables = model.tables.filter { aTable =>
		println("=>table=>" + aTable.name.table)
		tableNames.contains(aTable.name.table) })
	}
	
	println(modelFiltered.tables.size)
	val generator=new SourceCodeGeneratorEx(modelFiltered)
	generator.writeToFile(settings.slickDriver, settings.outputDirectory, settings.packageName, settings.rootTraitName, settings.scalaFileName)
	
	
}