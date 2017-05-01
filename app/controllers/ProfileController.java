package controllers;

import javax.inject.*;
import play.*;
import play.mvc.*;
import views.html.*;


@Singleton
public class ProfileController extends Controller {

    
	public Result profile(){
		return ok(profileindex.render("Its ready"));
	}
}

