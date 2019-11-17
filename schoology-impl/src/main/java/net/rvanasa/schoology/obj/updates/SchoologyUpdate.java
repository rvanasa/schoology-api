package net.rvanasa.schoology.obj.updates;

import java.util.Date;

import org.json.JSONObject;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.impl.SchoologyRealm;
import net.rvanasa.schoology.impl.SchoologyResponse;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;
import net.rvanasa.schoology.obj.attachments.SchoologyAttachments;
import net.rvanasa.schoology.obj.updates.comments.SchoologyUpdateComment;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/updates
 */
@Getter
public class SchoologyUpdate extends SchoologyReference<SchoologyUpdate>
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
	
	/**
	 * Depending on the realm, a different ID field is used
	 * 
	 * @return the ID based on realm of this update
	 */
	private String getRealmID()
	{
		switch (realm) {
		case USER:
			return uID;
		case COURSE_SECTION:
			return sectionID;
		case BUILDING:
			return buildingID;
		case GROUP:
			return groupID;
		default:
			return null;
		}
	}
	
	/**
	 * Post a comment to this update
	 * 
	 * @param comment
	 * @return comment object if success, else null
	 */
	public SchoologyUpdateComment postComment(String comment)
	{
		try {
			SchoologyResponse response = schoology.post(realm + getRealmID() + "/updates/" + ID + "/comments", new JSONObject().put("comment", comment).toString()).requireSuccess();
			
			return schoology.getGson().fromJson(response.getBody().parse().asRawData(), SchoologyUpdateComment.class).reference(schoology);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
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