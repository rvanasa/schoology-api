package net.rvanasa.schoology.obj.enrollment;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/enrollment
 */
@Getter
public class SchoologyEnrollment
{
	
	String id;
	String uid;
	String school_uid;
	String name_title;
	boolean name_title_show;
	String name_first;
	String name_first_preferred;
	boolean use_preferred_first_name;
	String name_middle;
	boolean name_middle_show;
	String name_last;
	String name_display;
	boolean admin;
	SchoologyEnrollmentStatus status;
	String picture_url;
	//Documentation missing
	int enrollment_source;
	
	SchoologyLinks links;
	
}
