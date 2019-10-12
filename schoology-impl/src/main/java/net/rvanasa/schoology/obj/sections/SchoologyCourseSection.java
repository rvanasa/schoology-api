package net.rvanasa.schoology.obj.sections;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course-section
 */
@Getter
public class SchoologyCourseSection extends SchoologyReference<SchoologyCourseSection>
{
	
	@SerializedName(value="id")
	String ID;
	@SerializedName(value="course_title")
	String courseTitle;
	@SerializedName(value="course_code")
	String courseCode;
	@SerializedName(value="course_id")
	String courseID;
	@SerializedName(value="school_id")
	String schoolID;
	@SerializedName(value="building_id")
	String buildingID;
	@SerializedName(value="access_code")
	String accessCode;
	@SerializedName(value="section_title")
	String sectionTitle;
	@SerializedName(value="section_code")
	String sectionCode;
	@SerializedName(value="section_school_code")
	String sectionSchoolCode;
	String synced;
	boolean active;
	String description;
	@SerializedName(value="subject_area")
	String subjectArea;
	@SerializedName(value="grade_level_range_start")
	int gradeLevelRangeStart;
	@SerializedName(value="grade_level_range_end")
	int gradeLevelRangeEnd;
	@SerializedName(value="parent_id")
	String parentID;
	@SerializedName(value="grading_periods")
	int[] gradingPeriods;
	@SerializedName(value="profile_url")
	String profileURL;
	String location;
	@SerializedName(value="meeting_days")
	int[] meetingDays;
	@SerializedName(value="start_time")
	String startTime;
	@SerializedName(value="end_time")
	String endTime;
	String weight;
	SchoologyCourseSectionOptions options;
	boolean admin;
	
	SchoologyLinks links;
	
}

@Getter
class SchoologyCourseSectionOptions
{
	
	@SerializedName(value="weighted_grading_categories")
	boolean weightedGradingCategories;
	@SerializedName(value="upload_documents")
	boolean uploadDocuments;
	@SerializedName(value="create_discussion")
	boolean createDiscussion;
	@SerializedName(value="member_post")
	boolean memberPost;
	@SerializedName(value="member_post_comment")
	boolean memberPostComment;
	@SerializedName(value="default_grading_scale_id")
	boolean defaultGradingScaleID;
	@SerializedName(value="content_index_visibility")
	SchoologyContentIndexVisibility contentIndexVisibility;
	@SerializedName(value="hide_overall_grade")
	boolean hideOverallGrade;
	@SerializedName(value="hide_grading_period_grade")
	boolean hideGradingPeriodGrade;
	@SerializedName(value="allow_custom_overall_grade")
	boolean allowCustomOverallGrade;
	@SerializedName(value="allow_custom_overall_grade_text")
	boolean allowCustomOverallGradeText;
	
	@Getter
	class SchoologyContentIndexVisibility{
		
		boolean topics;
		boolean assignments;
		boolean assessments;
		@SerializedName(value="course_assessment")
		boolean courseAssessment;
		@SerializedName(value="common_assessments")
		boolean commonAssessments;
		boolean documents;
		boolean discussion;
		boolean album;
		boolean pages;
		
	}
	
}
