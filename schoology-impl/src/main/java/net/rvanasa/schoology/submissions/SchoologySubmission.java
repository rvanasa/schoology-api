package net.rvanasa.schoology.submissions;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Represents a Schoology API's Submission JSON object as a Java object. See
 * https://developers.schoology.com/api-documentation/rest-api-v1/submissions
 * for more info.
 * 
 * @author jkstpierre
 *
 */
@Getter
public class SchoologySubmission {
  @SerializedName(value = "revision_id")
  String ID;
  @SerializedName(value = "uid")
  String userID;
  String created;
  Integer late;
  @SerializedName(value = "num_items")
  String numItems;
  Boolean draft;
  String body;
}
