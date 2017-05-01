package controllers;

import javax.inject.*;
import play.*;
import play.mvc.*;
import views.html.*;

import services.Counter;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class CountController extends Controller {

    
	public Result about(){
		return ok(aboutindex.render("Its ready"));
	}
}

