package net.rvanasa.schoology.obj.blog;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/blog-post
 */
@Getter
public class SchoologyBlogPost
{
	
	String id;
	String title;
	String body;
	Date created;
	
	SchoologyLinks links;
	
}
