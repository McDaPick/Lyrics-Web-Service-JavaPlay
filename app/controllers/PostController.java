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
import javax.persistence.*;


public class PostController extends Controller {


   public Result addUser(){
	   User user = Form.form(User.class).bindFromRequest().get();
	   user.save();
	   return  ok(postindex.render("Its ready"));
   }
   
   public Result getUser(){
	   List<User> users = new Model.Finder(String.class, User.class).all();
	   return ok(toJson(users));
   }
   
   public Result getUserById(){
	   DynamicForm dynamicForm = Form.form().bindFromRequest();
	   String id = dynamicForm.get("id");
	    int result = Integer.parseInt(id);
	   User user = User.find.byId(result);
	   	   return ok(toJson(user));

   }
   
   public Result deleteUser(){
	   DynamicForm dynamicForm = Form.form().bindFromRequest();
	   String id = dynamicForm.get("id");
	   int result = Integer.parseInt(id);
	   User user = User.find.byId(result);
	   user.delete();
	   return ok(postindex.render("Its ready"));
   }

	public Result updateUser(){
		DynamicForm dynamicForm = Form.form().bindFromRequest();
		 String id = dynamicForm.get("id");
	     int result = Integer.parseInt(id);
	     User user = User.find.byId(result);
		 
		 String upUser = dynamicForm.get("username");
		 String upPass = dynamicForm.get("pass");
		 String upSong = dynamicForm.get("song");

		 if(upUser.equals("")){
		 user.username = user.username;
		 } else {
		 user.username = upUser;
		 }
		 
		 if(upPass.equals("")){
			 user.pass = user.pass;
		 }else{
			 user.pass = upPass;
		 }
		 
		 if(upSong.equals("")){
			 user.song = user.song;
		 } else {
		 user.song =upSong;
		 }
		 
		 user.update();
		
		return ok(postindex.render("Its ready"));
	}
   
   public Result post(){
		return ok(postindex.render("Its ready"));
	}
}