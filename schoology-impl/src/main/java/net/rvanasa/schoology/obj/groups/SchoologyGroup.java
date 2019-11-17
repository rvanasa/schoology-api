package net.rvanasa.schoology.obj.groups;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/group
 */
@Getter
public class SchoologyGroup extends SchoologyReference<SchoologyGroup>
{
	
	@SerializedName(value="id")
	String ID;
	String title;
	String description;
	String website;
	@SerializedName(value="access_code")
	String accessCode;
	String category;
	SchoologyGroupOptions options;
	@SerializedName(value="group_code")
	String groupCode;
	@SerializedName(value="privacy_level")
	String privacyLevel;
	@SerializedName(value="picture_url")
	String pictureURL;
	@SerializedName(value="school_id")
	String schoolID;
	@SerializedName(value="building_id")
	String buildingID;
	
	SchoologyLinks links;
	
}

@Getter
class SchoologyGroupOptions
{
	
	@SerializedName(value="invite_type")
	boolean inviteType;
	@SerializedName(value="member_post")
	boolean memberPost;
	@SerializedName(value="member_post_comment")
	boolean memberPostComment;
	@SerializedName(value="create_discussion")
	boolean createDiscussion;
	@SerializedName(value="create_files")
	boolean createFiles;
	
}
