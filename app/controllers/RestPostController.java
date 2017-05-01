package controllers;

import javax.inject.Inject;
import play.*;
import views.html.*;
import play.mvc.*;
import play.db.*;
import play.data.DynamicForm;
import play.data.Form;
import models.User;
import com.avaje.ebean.Model;
import java.util.List;
import static play.libs.Json.toJson;
import static play.libs.Json.*;
import javax.persistence.*;
import org.codehaus.jackson.JsonNode;
import play.mvc.BodyParser;

public class RestPostController extends Controller {

   public Result addNewUser(){
	   JsonNode json = request().body().asJson();
	   
	   User user = JSon.fromJson(json,User.class);
	   
	   user.save();
	   return  ok(postindex.render("Its ready"));
   }
}
   