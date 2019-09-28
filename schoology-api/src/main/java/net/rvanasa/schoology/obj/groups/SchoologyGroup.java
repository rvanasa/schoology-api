package net.rvanasa.schoology.obj.groups;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/group
 */
@Getter
public class SchoologyGroup
{
	
	String id;
	String title;
	String description;
	String website;
	String access_code;
	String category;
	SchoologyGroupOptions options;
	String group_code;
	String privacy_level;
	String picture_url;
	String school_id;
	String building_id;
	
}

@Getter
class SchoologyGroupOptions
{
	
	boolean invite_type;
	boolean member_post;
	boolean member_post_comment;
	boolean create_discussion;
	boolean create_files;
	
}