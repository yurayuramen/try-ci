package test.dinesterr

import org.scalatestplus.play.OneAppPerSuite
import play.api.inject.guice.GuiceApplicationBuilder
import org.scalatestplus.play.PlaySpec
import play.api.Application
import dinesterr.Code02
import dinesterr.Code04
import com.google.inject.ProvisionException

class DINestErrorSpec extends PlaySpec with OneAppPerSuite{
  
  override lazy val app=new GuiceApplicationBuilder().build()
  
  "うまくいく" should{
    
    "" in
    {
      val code02=app.injector.instanceOf[Code02]
      //val code02=Application.instanceCache[Code02].apply(app)
      code02.hello() 
    }
  }
  
  "うまくいかない" should{
    
    "DI同士で循環参照例外（ProvisionException）がでる" in
    {
      intercept[ProvisionException]
      {
        val code04=Application.instanceCache[Code04].apply(app)
        code04.hello()
      }
    }
  }
  
}