package net.rvanasa.schoology.obj.discussions;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/discussion-thread
 */
@Getter
public class SchoologyDiscussionThread extends SchoologyReference<SchoologyDiscussionThread>
{
	
	@SerializedName(value="id")
	String ID;
	@SerializedName(value="uid")
	String userID;
	String title;
	String body;
	boolean graded;
	Date due;
	@SerializedName(value="grade_item_id")
	int gradeItemID;
	@SerializedName(value="grading_scale")
	int gradingScale;
	@SerializedName(value="grading_period")
	int gradingPeriod;
	@SerializedName(value="grading_category")
	int gradingCateogry;
	@SerializedName(value="max_points")
	float maxPoints;
	float factor;
	@SerializedName(value="is_final")
	boolean isFinal;
	boolean published;
	@SerializedName(value="require_initial_post")
	boolean requireInitialPost;
	//No documentation available
	@SerializedName(value="completion_status")
	boolean completionStatus;
	
	SchoologyLinks links;
	
}
