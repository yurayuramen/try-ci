package test.services

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.OneAppPerTest
import org.scalatestplus.play.OneAppPerSuite
import org.scalatest._
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.Application
import services.QueryOfP2Simple
import scala.concurrent.Await
import net.sf.ehcache.search.expression.GreaterThan

class QueryOfP2SimpleSpec extends PlaySpec with OneAppPerSuite{
  
  import scala.concurrent.duration.Duration._
  implicit override lazy val app = GuiceApplicationBuilder().build()
  
  "全件検索を行う" should
  {
    "１件以上の件数が返ればOK" in
    {
      val query = Application.instanceCache[QueryOfP2Simple].apply(app)
      val list = Await.result(query.all(),Inf)
      list.size must be  >= 1 
    }
  }
  "1件の検索取得を行う" should
  {

    "データが存在するケースのテスト" in
    {
      val query = Application.instanceCache[QueryOfP2Simple].apply(app)
      val row = Await.result(query.find(1),Inf)
      row.mustNot(be(None))
    }
    
    "データが存在しないケースのテスト" in
    {
      val query = Application.instanceCache[QueryOfP2Simple].apply(app)
      val row = Await.result(query.find(1000),Inf)
      row must be(None)
    }
    
  }
  
  
}