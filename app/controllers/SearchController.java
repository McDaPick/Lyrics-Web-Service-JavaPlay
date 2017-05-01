package controllers;

import javax.inject.*;
import play.*;
import play.mvc.*;
import views.html.*;
import play.data.DynamicForm;
import play.data.Form;
import java.util.List;
import com.omt.lyrics.SearchLyrics;
import com.omt.lyrics.beans.Lyrics;
import com.omt.lyrics.beans.LyricsServiceBean;
import com.omt.lyrics.exception.SearchLyricsException;
import static play.libs.Json.toJson;


import services.Counter;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class SearchController extends Controller {
	
	public Result searchLyrics(){
    DynamicForm dynamicForm = Form.form().bindFromRequest();
    Logger.info("song is: " + dynamicForm.get("song"));
    Logger.info("artist is: " + dynamicForm.get("artist"));

	
	String song = dynamicForm.get("song");
    String artist = dynamicForm.get("artist");

	     SearchLyrics sl = new SearchLyrics();
        LyricsServiceBean bean = new LyricsServiceBean();
		
		 bean.setSongName(song);
         bean.setSongAlbum(artist);

            List<Lyrics> lyrics = null;
            try {
                lyrics = sl.searchLyrics(bean);
         } catch (SearchLyricsException e) {
                // TODO Auto-generated catch block
            }
			
			
	
		return ok(toJson(lyrics)); 
	}
 
	public Result search(){
		return ok(searchindex.render("Its ready"));
	}
}

