package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import services.QueryOfP2Simple
import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(query:QueryOfP2Simple)(implicit ec:ExecutionContext) extends Controller {
  
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok("")
  }
  
  def getALLP2(id:Option[Int]=None) = Action.async{request=>
    
    id.fold{
      query.all().map{
        seq=> Ok(views.html.index(seq))
      }
    }{id=>
      query.find(id).map{
        row=> //:Seq[(Option[String],Option[String])]=>
        val seq=row.map(Seq(_)).getOrElse(Seq())
        Ok(views.html.index(seq))
      }
    }
  } 
}
