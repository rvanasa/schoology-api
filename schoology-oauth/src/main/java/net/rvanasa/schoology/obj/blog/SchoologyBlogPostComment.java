package net.rvanasa.schoology.obj.blog;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/blog-post-comment
 */
@Getter
public class SchoologyBlogPostComment
{
	
	String id;
	String uid;
	String comment;
	Date created;
	boolean status;
	
	SchoologyLinks links;
	
}
