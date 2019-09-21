package net.rvanasa.schoology.realms.users;

import lombok.Getter;

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
		for(SchoologyGenderEnum status : values()) if(status.apiVaule.equals(apiValue) || status.gender.equals(apiValue)) return status;
		
		return null;
	}
	
}
