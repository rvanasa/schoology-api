package net.rvanasa.schoology.obj.courses;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course#Subject-Area
 */
public enum SchoologyCourseSubjectAreaEnum
{
	
	OTHER(0, "Other"),
	HEALTH_AND_PHYSICAL_EDU(1, "Health & Physical Education"),
	LANGUAGE_ARTS(2, "Language Arts"),
	MATH(3, "Mathematics"),
	PROFESSIONAL_DEVELOPMENT(4, "Professional Development"),
	SCIENCE(5, "Science"),
	SOCIAL_STUDIES(6, "Social Studies"),
	SPECIAL_EDU(7, "Special Education"),
	TECH(8, "Technology"),
	ARTS(9, "Arts");
	
	@Getter
	private final int apiVaule;
	@Getter
	private final String subjectArea;
	
	private SchoologyCourseSubjectAreaEnum(int apiValue, String subjectArea)
	{
		this.apiVaule = apiValue;
		this.subjectArea = subjectArea;
	}
	
	public static SchoologyCourseSubjectAreaEnum getSubjectArea(int apiValue)
	{
		for(SchoologyCourseSubjectAreaEnum status : values()) if(status.getApiVaule() == apiValue) return status;
		
		return null;
	}
	
}
