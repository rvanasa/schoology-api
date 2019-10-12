package net.rvanasa.schoology.obj.events;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/event
 */
public enum SchoologyEventType
{
	
	@SerializedName(value="event")
	EVENT("event", "Normal event"),
	@SerializedName(value="assignment")
	ASSIGNMENT("assignment", "Due event for an assignment"),
	@SerializedName(value="discussion")
	DISCUSSION("discussion", "Due event for a discussion");
	
	@Getter
	private final String apiVaule;
	@Getter
	private final String description;
	
	private SchoologyEventType(String apiValue, String description)
	{
		this.apiVaule = apiValue;
		this.description = description;
	}
	
	public static SchoologyEventType getEventType(String apiValue)
	{
		for(SchoologyEventType eventType : values()) if(eventType.getApiVaule().equalsIgnoreCase(apiValue)) return eventType;
		
		return null;
	}
	
}
