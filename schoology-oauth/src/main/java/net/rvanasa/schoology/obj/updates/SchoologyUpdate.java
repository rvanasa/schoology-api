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