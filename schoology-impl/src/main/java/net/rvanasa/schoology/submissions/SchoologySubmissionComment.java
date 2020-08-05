package net.rvanasa.schoology.submissions;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Java representation of the Schoology API's Submission Comment JSON. For more
 * information see:
 * https://developers.schoology.com/api-documentation/rest-api-v1/submissions
 * 
 * @author jkstpierre
 *
 */
@Getter
public class SchoologySubmissionComment {
  @SerializedName(value = "id")
  String ID;
  @SerializedName(value = "uid")
  String userID;
  String comment;
  String created;
}
