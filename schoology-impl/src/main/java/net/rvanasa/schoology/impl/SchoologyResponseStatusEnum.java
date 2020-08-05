package net.rvanasa.schoology.impl;

import lombok.Getter;

public enum SchoologyResponseStatusEnum
{
	SUCCESS_OK(200, "OK"),
	SUCCESS_CREATED(201, "Create"),
	SUCCESS_NO_CONTENT(204, "No content"),
	
	UNAUTHORIZED(401, "Unauthorized"),
	PERMISSION(403, "Insufficient permission level"),
	NOT_FOUND(404, "Resource not found"),
	NOT_ALLOWED(405, "Method not allowed"),
	
	UNKNOWN(-1, "Unknown status");
	
	@Getter 
	private final int code;
	@Getter
	private final String message;
	
	private SchoologyResponseStatusEnum(int code, String message)
	{
		this.code = code;
		this.message = message;
	}
	
	public boolean isSuccess()
	{
		return this.name().startsWith("SUCCESS");
	}
	
	public static SchoologyResponseStatusEnum getStatus(int code)
	{
		for(SchoologyResponseStatusEnum status : values())
		{
			if(status.getCode() == code)
			{
				return status;
			}
		}
		return UNKNOWN;
	}
}
