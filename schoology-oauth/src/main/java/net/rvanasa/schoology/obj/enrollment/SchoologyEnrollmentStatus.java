package net.rvanasa.schoology.obj.enrollment;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/enrollment
 */
public enum SchoologyEnrollmentStatus
{
	
	@SerializedName(value="1")
	ACTIVE(1, "Active"),
	@SerializedName(value="2")
	EXPIRED(2, "Expired"),
	@SerializedName(value="3")
	INVITE_PENDING(3, "Invite pending"),
	@SerializedName(value="4")
	REQUEST_PENDING(4, "Request pending"),
	@SerializedName(value="5")
	ARCHIVED(5, "Archived");
	
	@Getter
	private final int apiVaule;
	@Getter
	private final String description;
	
	private SchoologyEnrollmentStatus(int apiValue, String description)
	{
		this.apiVaule = apiValue;
		this.description = description;
	}
	
	public static SchoologyEnrollmentStatus getEnrollmentStatus(int apiValue)
	{
		for(SchoologyEnrollmentStatus status : values()) if(status.getApiVaule() == apiValue) return status;
		
		return null;
	}
	
}
