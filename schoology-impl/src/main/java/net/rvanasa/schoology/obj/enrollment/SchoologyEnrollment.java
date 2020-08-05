package net.rvanasa.schoology.obj.enrollment;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/enrollment
 */
@Getter
@Setter
public class SchoologyEnrollment extends SchoologyReference<SchoologyEnrollment> {
  @SerializedName(value = "id")
  String ID;
  @SerializedName(value = "uid")
  String userID;
  @SerializedName(value = "school_uid")
  String schoolUID;
  @SerializedName(value = "name_title")
  String nameTitle;
  @SerializedName(value = "name_title_show")
  boolean nameTitleShow;
  @SerializedName(value = "name_first")
  String nameFirst;
  @SerializedName(value = "name_first_preferred")
  String nameFirstPreferred;
  @SerializedName(value = "use_preferred_first_name")
  boolean usePreferredFirstName;
  @SerializedName(value = "name_middle")
  String nameMiddle;
  @SerializedName(value = "name_middle_show")
  boolean nameMiddleShow;
  @SerializedName(value = "name_last")
  String nameLast;
  @SerializedName(value = "name_display")
  String nameDisplay;
  boolean admin;
  SchoologyEnrollmentStatus status;
  @SerializedName(value = "picture_url")
  String pictureURL;
  // Documentation missing
  @SerializedName(value = "enrollment_source")
  int enrollmentSource;

  SchoologyLinks links;

}
