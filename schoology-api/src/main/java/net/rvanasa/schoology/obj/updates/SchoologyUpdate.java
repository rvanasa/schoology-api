package net.rvanasa.schoology.obj.updates;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.SchoologyRealmEnum;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.attachments.SchoologyAttachments;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/updates
 */
@Getter
public class SchoologyUpdate
{
	
	String id;
	String body;
	String uid;
	Date created;
	Date last_updated;
	SchoologyRealmEnum realm;
	int likes;
	boolean user_like_action;
	
	//Only one of these variables will be used depending on the realm
	String user_id;
	String section_id;
	String building_id;
	String group_id;
	
	int num_comments;
	
	//TODO: ?with_attachments=true must be specified, but then info such as the realm will be missing
	SchoologyAttachments attachments;
	
	//TODO: Untested. Are these even included in update object?
	SchoologyPoll polls;
	
	SchoologyLinks links;
	
}
//TODO:
@Getter
class SchoologyPoll
{
	
	SchoologyPollOptions[] poll;
	
}
//TODO:
@Getter
class SchoologyPollOptions
{
	
	String title;
	int count;
	boolean selected;
	
}