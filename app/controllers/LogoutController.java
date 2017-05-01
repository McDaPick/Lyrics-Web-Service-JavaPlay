package controllers;

import javax.inject.*;
import play.*;
import play.mvc.*;
import views.html.*;
import play.data.DynamicForm;
import play.data.Form;



@Singleton
public class LogoutController extends Controller {

	public Result logout(){
		return ok(logoutindex.render("Its ready"));
	}
}

