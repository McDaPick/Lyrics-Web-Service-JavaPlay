package controllers;

import javax.inject.*;
import play.*;
import play.mvc.*;
import views.html.*;
import play.data.DynamicForm;
import play.data.Form;


import services.Counter;


@Singleton
public class LoginController extends Controller {
	
	public Result loginCred(){
    DynamicForm dynamicForm = Form.form().bindFromRequest();
    Logger.info("username is: " + dynamicForm.get("name"));
    Logger.info("password is: " + dynamicForm.get("password"));
	
	String userEnter = dynamicForm.get("name");
	String passEnter = dynamicForm.get("password");
	
	String compName = "mnielsen";
	String compPass = "shelby";
	
	if(userEnter.equals(compName) && passEnter.equals(compPass)){
		Logger.info("Welcome " + userEnter);
		
	} else {
		Logger.info("Sorry incorrect username or password");
	}
		
				return ok(loginindex.render("Its ready"));

	}
	

	public Result login(){
		return ok(loginindex.render("Its ready"));
	}
}

