package net.rvanasa.schoology.obj.courses;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course
 */
@Getter
public class SchoologyCourse
{
	
	String id;
	String building_id;
	String title;
	String course_code;
	String department;
	String description;
	double credits;
	boolean synced;
	SchoologyGradeRangeEnum grade_level_range_start;
	SchoologyGradeRangeEnum grade_level_range_end;
	SchoologyCourseSubjectAreaEnum subject_area;
	
}