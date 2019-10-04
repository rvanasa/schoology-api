package net.rvanasa.schoology.obj.users;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/user
 */
@Getter
public class SchoologyUser
{
	
	//Same as uid
	String id;
	String uid;
	String school_id;
	String building_id;
	String school_uid;
	String name_title;
	boolean name_title_show;
	String name_first;
	String name_first_preferred;
	String name_middle;
	String name_middle_show;
	String name_last;
	String name_display;
	String username;
	String primary_email;
	String position;
	SchoologyGenderEnum gender;
	int grad_year;
	String birthday_date;
	//Must have 'Administer users' permission
	String password;
	//Must have 'Administer users' permission
	int role_id;
	boolean email_login_info;
	String profile_url;
	String tz_name;
	// 'View user parents' permission required from schoology API to access this information
	SchoologyUser[] parents;
	//TODO: comma-delimited list of integers
	String parent_uids;
	//TODO: comma-delimited list of integers
	String advisor_uids;
	//TODO: comma-delimited list of integers
	String child_urls;
	int send_message;
	boolean synced;
	int profile_picture_fid;
	//TODO: comma-delimited list of integers
	String additional_buildings;
	
	SchoologyProfileInfo profile_info;
	
	//Missing from API documentation on Schoology
	boolean use_preferred_first_name;
	//Missing from schoology documentation
	boolean admin;
	boolean status;
	
	SchoologyLinks links;
	
}

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/user
 * Must request extended user info to receive
 */
@Getter
class SchoologyProfileInfo
{
	
	//Teacher only
	String subjects_taught;
	String grades_taught;
	String position;
	String department;
	
	//All users (teachers + students)
	String bio;
	String phone;
	String website;
	String address;
	String interests;
	String acivities;
	String birthday_date;
	String birthday;
	
}

/*
 * No documentation available
 */
@Getter
class SchoologyPermissions
{
	
	boolean is_directory_public;
	boolean allow_connections;
	
}
