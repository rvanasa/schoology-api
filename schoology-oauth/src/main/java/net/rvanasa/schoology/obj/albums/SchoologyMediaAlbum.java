package net.rvanasa.schoology.obj.albums;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album
 */
@Getter
public class SchoologyMediaAlbum
{
	
	String id;
	String title;
	String description;
	boolean setting_comments;
	boolean setting_member_post;
	boolean published;
	int photo_count;
	int video_count;
	int audio_count;
	String cover_image_url;
	Date created;
	boolean available;
	boolean completed;
	//No documentation available
	String completion_status;
	
	SchoologyLinks links;
	
}
