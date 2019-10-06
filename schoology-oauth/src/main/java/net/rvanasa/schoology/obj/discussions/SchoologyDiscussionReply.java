package net.rvanasa.schoology.obj.discussions;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/discussion-reply
 */
@Getter
public class SchoologyDiscussionReply
{

	@SerializedName(value="id")
	String ID;
	@SerializedName(value="uid")
	String userID;
	String comment;
	Date created;
	@SerializedName(value="parent_id")
	String parentID;
	boolean status;
	int likes;
	@SerializedName(value="user_like_action")
	boolean userLikeAction;
	
	SchoologyLinks links;

}
