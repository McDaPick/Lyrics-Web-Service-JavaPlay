package models;

import java.util.*;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User extends Model {

   @Id
   public Integer id;
   
   public String username;
   
   public String pass;
   
   public String song;
   
   public static Finder<Integer, User> find = new Finder<Integer,User>(Integer.class, User.class);
}