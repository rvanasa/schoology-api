package net.rvanasa.schoology.obj.users;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/user
 */
public enum SchoologyGenderEnum
{
	
	@SerializedName(value="M")
	MALE("M", "Male"),
	@SerializedName(value="F")
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
