package services

import javax.inject.Inject
import play.api.db.slick.HasDatabaseConfig
import slick.driver.JdbcProfile
import model.HelloActiveAdm.P2Simples
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.db.NamedDatabase
import scala.concurrent.Future

object QueryOfP2Simple
{
  case class Row1(id:Int,name:Option[String],memo:Option[String])
}

class QueryOfP2Simple @Inject()(@NamedDatabase("test01") val dbConfigProvider:DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {
  
  import play.api.libs.concurrent.Execution.Implicits.defaultContext
  import slick.driver.MySQLDriver.api._
  import QueryOfP2Simple._
  
  def all():Future[Seq[Row1]]={
    val action = P2Simples.map{tableDef=> (tableDef.id, tableDef.name, tableDef.memo) <> (Row1.tupled , Row1.unapply) }.result
    this.db.run(action)
  }
  
  def find(id:Int):Future[Option[Row1]]={
    val action = P2Simples.filter{_.id === id}.map{tableDef=> (tableDef.id, tableDef.name, tableDef.memo) <> (Row1.tupled , Row1.unapply) }.result
    this.db.run(action).map(_.headOption)
  }
  
  
}