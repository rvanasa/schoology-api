package net.rvanasa.schoology.obj.users;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/user
 */
public enum SchoologyGenderEnum
{
	
	MALE("M", "Male"),
	FEMALE("F", "Female");
	
	@Getter
	private final String apiVaule;
	@Getter
	private final String gender;
	
	private SchoologyGenderEnum(String apiValue, String subjectArea)
	{
		this.apiVaule = apiValue;
		this.gender = subjectArea;
	}
	
	public static SchoologyGenderEnum getGender(String apiValue)
	{
		for(SchoologyGenderEnum gender : values()) if(gender.apiVaule.equalsIgnoreCase(apiValue) || gender.gender.equalsIgnoreCase(apiValue)) return gender;
		
		return null;
	}
	
}
