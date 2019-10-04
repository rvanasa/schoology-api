package net.rvanasa.schoology.obj.discussions;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/discussion-reply
 */
@Getter
public class SchoologyDiscussionReply
{

	String id;
	String uid;
	String comment;
	Date created;
	String parent_id;
	boolean status;
	int likes;
	boolean user_like_action;
	
	SchoologyLinks links;

}
