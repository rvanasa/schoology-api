package net.rvanasa.schoology.obj.discussions;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/discussion-thread
 */
@Getter
public class SchoologyDiscussionThread
{
	
	String id;
	String uid;
	String title;
	String body;
	boolean graded;
	Date due;
	int grade_item_id;
	int grading_scale;
	int grading_period;
	int grading_cateogry;
	float max_points;
	float factor;
	boolean is_final;
	boolean published;
	boolean require_initial_post;
	//No documentation available
	boolean completion_status;
	
	SchoologyLinks links;
	
}
