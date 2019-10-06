package net.rvanasa.schoology.obj.updates;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.impl.SchoologyRealm;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.attachments.SchoologyAttachments;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/updates
 */
@Getter
public class SchoologyUpdate
{
	
	@SerializedName(value="id")
	String ID;
	String body;
	//Should be same as userID if this is for a user realm
	@SerializedName(value="uid")
	String userID;
	Date created;
	@SerializedName(value="last_updated")
	Date lastUpdated;
	SchoologyRealm realm;
	int likes;
	@SerializedName(value="user_like_action")
	boolean userLikeAction;
	
	//Only one of these variables will be used depending on the realm
	@SerializedName(value="user_id")
	String uID;
	@SerializedName(value="section_id")
	String sectionID;
	@SerializedName(value="building_id")
	String buildingID;
	@SerializedName(value="group_id")
	String groupID;
	
	@SerializedName(value="num_comments")
	int numComments;
	
	//TODO: ?with_attachments=true must be specified, but then info such as the realm will may be missing
	SchoologyAttachments attachments;
	
	//Polls are only included for update objects
	SchoologyPoll polls;
	
	SchoologyLinks links;
	
}

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/poll
 */
@Getter
class SchoologyPoll
{
	
	SchoologyPollOptions[] poll;
	
}

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/poll
 */
@Getter
class SchoologyPollOptions
{
	
	String id;
	String title;
	int count;
	boolean selected;
	
}