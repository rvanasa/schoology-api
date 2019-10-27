package net.rvanasa.schoology.obj.users;

import org.json.JSONObject;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.impl.SchoologyRealm;
import net.rvanasa.schoology.obj.SchoologyReference;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/user
 */
@Getter
public class SchoologyUser extends SchoologyReference<SchoologyUser>
{
	
	//Same as uid
	@SerializedName(value="id")
	String ID;
	@SerializedName(value="uid")
	String userID;
	@SerializedName(value="school_id")
	String schoolID;
	@SerializedName(value="building_id")
	String buildingID;
	@SerializedName(value="school_uid")
	String schoolUID;
	@SerializedName(value="name_title")
	String nameTitle;
	@SerializedName(value="name_title_show")
	boolean nameTitleShow;
	@SerializedName(value="name_first")
	String nameFirst;
	@SerializedName(value="name_first_preferred")
	String nameFirstPreferred;
	@SerializedName(value="name_middle")
	String nameMiddle;
	@SerializedName(value="name_middle_show")
	String nameMiddleShow;
	@SerializedName(value="name_last")
	String nameLast;
	@SerializedName(value="name_display")
	String nameDisplay;
	String username;
	@SerializedName(value="primary_email")
	String primaryEmail;
	String position;
	SchoologyGenderEnum gender;
	@SerializedName(value="grad_year")
	int gradYear;
	@SerializedName(value="birthday_date")
	String birthdayDate;
	//Must have 'Administer users' permission
	String password;
	//Must have 'Administer users' permission
	@SerializedName(value="role_id")
	int roleID;
	@SerializedName(value="email_login_info")
	boolean emailLoginInfo;
	@SerializedName(value="picture_url")
	String pictureURL;
	@SerializedName(value="tz_name")
	String tzName;
	// 'View user parents' permission required from schoology API to access this information
	SchoologyUser[] parents;
	//TODO: comma-delimited list of integers
	@SerializedName(value="parent_uids")
	String parentUIDs;
	//TODO: comma-delimited list of integers
	@SerializedName(value="advisor_uids")
	String advisorUIDs;
	//TODO: comma-delimited list of integers
	@SerializedName(value="child_urls")
	String childURLs;
	@SerializedName(value="send_message")
	int sendMessage;
	boolean synced;
	@SerializedName(value="profile_picture_fid")
	int profilePictureFID;
	//TODO: comma-delimited list of integers
	@SerializedName(value="additional_buildings")
	String additionalBuildings;
	
	@SerializedName(value="profile_info")
	SchoologyProfileInfo profileInfo;
	
	//Missing from API documentation on Schoology
	@SerializedName(value="use_preferred_first_name")
	boolean usePreferredFirstName;
	//Missing from schoology documentation
	boolean admin;
	boolean status;
	
	public void setNameFirstPreferred(String nameFirstPreferred)
	{
		schoology.put(SchoologyRealm.USER + ID, new JSONObject().put("name_first_preferred", nameFirstPreferred).toString()).requireSuccess();
		
		this.nameFirstPreferred = nameFirstPreferred;
	}
	
}

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/user
 * Must request extended user info to receive
 */
@Getter
class SchoologyProfileInfo
{
	
	//Teacher only
	@SerializedName(value="subjects_taught")
	String subjectsTaught;
	@SerializedName(value="grades_taught")
	String gradesTaught;
	String position;
	String department;
	
	//All users (teachers + students)
	String bio;
	String phone;
	String website;
	String address;
	String interests;
	String activities;
	@SerializedName(value="birthday_date")
	String birthdayDate;
	String birthday;
	
}

/*
 * No documentation available
 */
@Getter
class SchoologyPermissions
{

	@SerializedName(value="is_directory_public")
	boolean isDirectoryPublic;
	@SerializedName(value="allow_connections")
	boolean allowConnection;
	
}
