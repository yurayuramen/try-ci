package test.controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.OneAppPerSuite
import org.scalatestplus.play._
import org.scalatest._
import play.api.test._
import play.api.test.Helpers._

import controllers.HomeController
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.Application
import scala.concurrent.Await
import play.api.test.FakeRequest
import org.slf4j.LoggerFactory

class HomeControllerSpec extends PlaySpec with OneAppPerSuite{
  
  private[this] val logger=LoggerFactory.getLogger(this.getClass)
  
  import scala.concurrent.duration.Duration._
  implicit override lazy val app = GuiceApplicationBuilder().build()
  
  "検索:routerを使わない書き方" should
  {
    "table:tdタグをもとにデータが返ってきていることを確認" in
    {
      val controller = Application.instanceCache[HomeController].apply(app)
      val request = FakeRequest()
      val f_result = controller.getALLP2().apply(request)
      
      val html = contentAsString(f_result)
      
      logger.info(html)
      Await.result(f_result, Inf).header.status must be(200)
      html must include("<td>たごさく</td>")
    }
    
    "id:2" in
    {
      val controller = Application.instanceCache[HomeController].apply(app)
      val request = FakeRequest()
      val f_result = controller.getALLP2(Some(2)).apply(request)
      val html = contentAsString(f_result)
      
      logger.info(html)
      Await.result(f_result, Inf).header.status must be(200)
      html must include("<td>やの</td>")
    }
    
  }

  "検索:routerを使った書き方" should
  {
    "table:tdタグをもとにデータが返ってきていることを確認" in
    {
      val request = FakeRequest("GET","/home/p2")
      route(app, request).fold{
        this.assertTypeError("route-nou-found")
      }{f_result=>
        val html = contentAsString(f_result)
        logger.info(html)
        Await.result(f_result, Inf).header.status must be(200)
        html must include("<td>たごさく</td>")
        
      }
    }
    
    "id:2" in
    {
      val request = FakeRequest("GET","/home/p2?id=2")
      route(app, request).fold{
        this.assertTypeError("route-nou-found")
      }{f_result=>
        val html = contentAsString(f_result)
        logger.info(html)
        Await.result(f_result, Inf).header.status must be(200)
        html must include("<td>やの</td>")
      }
    }
    
  }
  
}