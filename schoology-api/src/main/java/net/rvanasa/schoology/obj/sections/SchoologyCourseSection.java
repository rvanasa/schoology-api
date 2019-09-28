package net.rvanasa.schoology.obj.sections;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course-section
 */
@Getter
public class SchoologyCourseSection
{
	
	String id;
	String course_title;
	String course_code;
	String course_id;
	String school_id;
	String building_id;
	String access_code;
	String section_title;
	String section_code;
	String section_school_code;
	String synced;
	int active;
	String description;
	String subject_area;
	int grade_level_range_start;
	int grade_level_range_end;
	String parent_id;
	int[] grading_periods;
	String profile_url;
	String location;
	int[] meeting_days;
	String start_time;
	String end_time;
	String weight;
	SchoologyCourseSectionOptions options;
	int admin;
	
}

@Getter
class SchoologyCourseSectionOptions
{
	
	boolean weighted_grading_categories;
	boolean upload_documents;
	boolean create_discussion;
	boolean member_post;
	boolean member_post_comment;
	boolean default_grading_scale_id;
	SchoologyContentIndexVisibility content_index_visibility;
	boolean hide_overall_grade;
	boolean hide_grading_period_grade;
	boolean allow_custom_overall_grade;
	boolean allow_custom_overall_grade_text;
	
	@Getter
	class SchoologyContentIndexVisibility{
		
		boolean topics;
		boolean assignments;
		boolean assessments;
		boolean course_assessment;
		boolean common_assessments;
		boolean documents;
		boolean discussion;
		boolean album;
		boolean pages;
		
	}
	
}
