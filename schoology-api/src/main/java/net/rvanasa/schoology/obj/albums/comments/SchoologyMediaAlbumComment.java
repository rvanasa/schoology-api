package net.rvanasa.schoology.obj.albums.comments;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album-comments
 */
@Getter
public class SchoologyMediaAlbumComment 
{
	
	String id;
	String content_id;
	String uid;
	String comment;
	Date created;
	boolean status;
	
	SchoologyLinks links;
	
}
