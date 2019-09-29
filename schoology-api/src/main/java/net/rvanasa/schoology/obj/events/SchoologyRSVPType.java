package net.rvanasa.schoology.obj.events;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/event
 */
public enum SchoologyRSVPType
{
	
	NO_ONE(0, "No one can RSVP"),
	INVITE_ONLY(1, "Only people who have been invited to the event"),
	EVERYONE(2, "Anyone can RSVP");
	
	@Getter
	private final int apiVaule;
	@Getter
	private final String description;
	
	private SchoologyRSVPType(int apiValue, String description)
	{
		this.apiVaule = apiValue;
		this.description = description;
	}
	
	public static SchoologyRSVPType getRSVPType(int apiValue)
	{
		for(SchoologyRSVPType eventType : values()) if(eventType.getApiVaule() == apiValue) return eventType;
		
		return null;
	}
	
}
