package net.rvanasa.schoology.obj.messages;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/private-messaging
 */
public enum SchoologyMessageStatus
{
	
	@SerializedName(value="read")
	READ("read"),
	@SerializedName(value="unread")
	UNREAD("unread");
	
	@Getter
	private final String apiVaule;
	
	private SchoologyMessageStatus(String apiValue)
	{
		this.apiVaule = apiValue;
	}
	
	public static SchoologyMessageStatus getEventType(String apiValue)
	{
		for(SchoologyMessageStatus eventType : values()) if(eventType.getApiVaule().equalsIgnoreCase(apiValue)) return eventType;
		
		return null;
	}
	
}
