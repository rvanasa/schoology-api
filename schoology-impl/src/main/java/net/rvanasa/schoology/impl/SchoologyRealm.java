package net.rvanasa.schoology.impl;

import com.google.gson.annotations.SerializedName;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1#Realms
 */
public enum SchoologyRealm
{	
	
	@SerializedName(value="school", alternate = {"schools"})
	SCHOOL("school", "schools"),
	//TODO: building endpoint? 'schools/{id}/buildings
	@SerializedName(value="building", alternate = {"buildings"})
	BUILDING("building", "buildings"),
	@SerializedName(value="user", alternate = {"users"})
	USER("user", "users"),
	@SerializedName(value="group", alternate = {"groups"})
	GROUP("group", "groups"),
	@SerializedName(value="course", alternate = {"courses"})
	COURSE("course", "courses"),
	@SerializedName(value="section", alternate = {"sections"})
	COURSE_SECTION("section", "sections"),
	
	;
	
	//What the type is referred to
	String name;
	//Endpoint used
	String endpoint;
	
	private SchoologyRealm(String name, String endpoint)
	{
		this.name = name;
		this.endpoint = endpoint;
	}
	
	public static SchoologyRealm getRealm(String apiValue)
	{
		for(SchoologyRealm realm : values()) if(realm.name.equalsIgnoreCase(apiValue) || realm.endpoint.equalsIgnoreCase(apiValue)) return realm;
		
		return null;
	}
	
	@Override
	public String toString()
	{
		return endpoint + "/";
	}
	
}
