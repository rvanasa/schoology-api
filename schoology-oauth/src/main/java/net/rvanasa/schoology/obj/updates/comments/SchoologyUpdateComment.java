package net.rvanasa.schoology.obj.updates.comments;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/update-comment
 */
@Getter
public class SchoologyUpdateComment
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