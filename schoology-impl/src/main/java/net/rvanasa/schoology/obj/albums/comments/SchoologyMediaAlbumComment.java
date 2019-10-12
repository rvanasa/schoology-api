package net.rvanasa.schoology.obj.albums.comments;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album-comments
 */
@Getter
public class SchoologyMediaAlbumComment extends SchoologyReference<SchoologyMediaAlbumComment>
{
	
	@SerializedName(value="id")
	String ID;
	@SerializedName(value="content_id")
	String contentID;
	@SerializedName(value="uid")
	String userID;
	String comment;
	Date created;
	boolean status;
	
	SchoologyLinks links;
	
}
