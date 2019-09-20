package net.rvanasa.schoology.realms.groups;

import lombok.Getter;

@Getter
public class SchoologyGroup {
	
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
class SchoologyGroupOptions{
	
	boolean invite_type;
	boolean member_post;
	boolean member_post_comment;
	boolean create_discussion;
	boolean create_files;
	
}