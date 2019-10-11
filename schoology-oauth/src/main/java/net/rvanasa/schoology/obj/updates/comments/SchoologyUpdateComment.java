package net.rvanasa.schoology.obj.updates.comments;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/update-comment
 */
@Getter
public class SchoologyUpdateComment extends SchoologyReference<SchoologyUpdateComment>
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