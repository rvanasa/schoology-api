package net.rvanasa.schoology.obj.enrollment;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/enrollment
 */
public enum SchoologyEnrollmentStatus
{
	
	ACTIVE(1, "Active"),
	EXPIRED(2, "Expired"),
	INVITE_PENDING(3, "Invite pending"),
	REQUEST_PENDING(4, "Request pending"),
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
		for(SchoologyEnrollmentStatus eventType : values()) if(eventType.getApiVaule() == apiValue) return eventType;
		
		return null;
	}
	
}
