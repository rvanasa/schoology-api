package net.rvanasa.schoology.obj.blog;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/blog-post
 */
@Getter
public class SchoologyBlogPost
{
	
	@SerializedName(value="id")
	String ID;
	String title;
	String body;
	Date created;
	
	SchoologyLinks links;
	
}
