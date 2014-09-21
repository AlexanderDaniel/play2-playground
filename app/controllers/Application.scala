package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  case class UserData(name: String, age: Int, password: String)

  val userForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "age" -> number(min = 0, max = 100),
      "password" -> nonEmptyText
    )(UserData.apply)(UserData.unapply)
  )

  def forms = Action {
    Ok(views.html.forms.fields(userForm))
  }

  def userPost() = play.mvc.Results.TODO
}