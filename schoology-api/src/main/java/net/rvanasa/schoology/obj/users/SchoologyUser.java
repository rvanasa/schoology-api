package net.rvanasa.schoology.obj.users;

import lombok.Getter;

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
	String password;
	int role_id;
	boolean email_login_info;
	String profile_url;
	String tz_name;
	//TODO:
	String parents;
	String parent_uids;
	String advisor_uids;
	String child_urls;
	int send_message;
	boolean synced;
	int profile_picture_fid;
	String additional_buildings;
	
	SchoologyProfileInfo profile_info;
	
	//TODO: from group request of user these three values appear
	//Missing from API documentation on Schoology
	boolean use_preferred_first_name;
	//Missing from schoology documentation
	boolean admin;
	boolean status;
	
}

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

@Getter
class SchoologyPermissions
{
	//TODO:
}
