package net.rvanasa.schoology.obj.courses;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course
 */
@Getter
public class SchoologyCourse extends SchoologyReference<SchoologyCourse>
{
	
	@SerializedName(value="id")
	String ID;
	@SerializedName(value="building_id")
	String buildingID;
	String title;
	@SerializedName(value="course_code")
	String courseCode;
	String department;
	String description;
	double credits;
	boolean synced;
	@SerializedName(value="grade_level_range_start")
	SchoologyGradeRangeEnum gradeLevelRangeStart;
	@SerializedName(value="grade_level_range_end")
	SchoologyGradeRangeEnum gradeLevelRangeEnd;
	@SerializedName(value="subject_area")
	SchoologyCourseSubjectAreaEnum subjectArea;
	
	SchoologyLinks links;
	
}