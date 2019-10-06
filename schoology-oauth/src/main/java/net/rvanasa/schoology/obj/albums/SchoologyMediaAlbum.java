package net.rvanasa.schoology.obj.albums;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album
 */
@Getter
public class SchoologyMediaAlbum
{
	
	@SerializedName(value="id")
	String ID;
	String title;
	String description;
	@SerializedName(value="setting_comments")
	boolean settingComments;
	@SerializedName(value="setting_member_post")
	boolean settingMemberPost;
	boolean published;
	@SerializedName(value="photo_count")
	int photoCount;
	@SerializedName(value="video_count")
	int videoCount;
	@SerializedName(value="audio_count")
	int audioCount;
	@SerializedName(value="cover_image_url")
	String coverImageURL;
	Date created;
	boolean available;
	boolean completed;
	//No documentation available
	@SerializedName(value="completion_status")
	String completionStatus;
	
	SchoologyLinks links;
	
}
