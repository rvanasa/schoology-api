package net.rvanasa.schoology.obj.courses;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course#Subject-Area
 */
public enum SchoologyCourseSubjectAreaEnum
{
	
	@SerializedName(value="0")
	OTHER(0, "Other"),
	@SerializedName(value="1")
	HEALTH_AND_PHYSICAL_EDU(1, "Health & Physical Education"),
	@SerializedName(value="2")
	LANGUAGE_ARTS(2, "Language Arts"),
	@SerializedName(value="3")
	MATH(3, "Mathematics"),
	@SerializedName(value="4")
	PROFESSIONAL_DEVELOPMENT(4, "Professional Development"),
	@SerializedName(value="5")
	SCIENCE(5, "Science"),
	@SerializedName(value="6")
	SOCIAL_STUDIES(6, "Social Studies"),
	@SerializedName(value="7")
	SPECIAL_EDU(7, "Special Education"),
	@SerializedName(value="8")
	TECH(8, "Technology"),
	@SerializedName(value="9")
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
	
	public static SchoologyCourseSubjectAreaEnum getCourseSubjectArea(int apiValue)
	{
		for(SchoologyCourseSubjectAreaEnum subjectArea : values()) if(subjectArea.getApiVaule() == apiValue) return subjectArea;
		
		return null;
	}
	
}
