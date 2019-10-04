package net.rvanasa.schoology;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1#Realms
 */
public enum SchoologyRealmEnum
{	
	
	SCHOOL("school", "schools"),
	//TODO: building endpoint? 'schools/{id}/buildings
	BUILDING("building", "buildings"),
	USER("user", "users"),
	GROUP("group", "groups"),
	COURSE("course", "courses"),
	COURSE_SECTION("section", "sections"),
	
	;
	
	//What the type is referred to
	@Getter
	String name;
	//Endpoint used
	@Getter
	String endpoint;
	
	private SchoologyRealmEnum(String name, String endpoint)
	{
		this.name = name;
		this.endpoint = endpoint;
	}
	
	public static SchoologyRealmEnum getRealm(String apiValue)
	{
		for(SchoologyRealmEnum realm : values()) if(realm.name.equalsIgnoreCase(apiValue) || realm.endpoint.equalsIgnoreCase(apiValue)) return realm;
		
		return null;
	}
	
}
