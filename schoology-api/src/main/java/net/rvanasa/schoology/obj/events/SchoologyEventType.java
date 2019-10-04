package net.rvanasa.schoology.obj.events;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/event
 */
public enum SchoologyEventType
{
	
	EVENT("event", "Normal event"),
	ASSIGNMENT("assignment", "Due event for an assignment"),
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
