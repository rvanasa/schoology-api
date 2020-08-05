package net.rvanasa.schoology.obj.assignments;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Represents the JSON for an Assignment in the Schoology API as a Java object.
 * See:
 * https://developers.schoology.com/api-documentation/rest-api-v1/assignment for
 * more information.
 * 
 * @author jkstpierre
 *
 */
@Getter
public class SchoologyAssignment {
  @SerializedName(value = "id")
  String ID;

  String title;

  String description;

  @SerializedName(value = "due")
  String dueDate;

  @SerializedName(value = "grading_scale")
  Integer gradingScale;

  @SerializedName(value = "grading_period")
  Integer gradingPeriod;

  @SerializedName(value = "grading_category")
  Integer gradingCategory;

  @SerializedName(value = "max_points")
  Float maxPoints;

  Float factor;
  
  @SerializedName(value = "is_final")
  Boolean isFinal;
  
  @SerializedName(value = "show_comments")
  Boolean showComments;
  
  @SerializedName(value = "grade_stats")
  Boolean gradeStats;
  
  @SerializedName(value = "allow_dropbox")
  Boolean allowDropbox;
  
  @SerializedName(value = "allow_discussion")
  Boolean allowDiscussion;
  
  Boolean published;
  
  String type;
  
  @SerializedName(value = "grade_item_id")
  Integer gradeItemId;
  
  @SerializedName(value = "dropbox_submissions")
  Integer dropboxSubmissions;
  
  @SerializedName(value = "dropbox_last_submission")
  Integer dropboxLastSubmission;
  
  @SerializedName(value = "show_rubric")
  Boolean showRubric;
  
  Integer[] assignees;
  
  @SerializedName(value = "grading_group_ids")
  Integer[] gradingGroupIds;
}
