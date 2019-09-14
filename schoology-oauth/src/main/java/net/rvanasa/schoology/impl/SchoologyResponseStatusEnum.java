package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.SchoologyResponseStatus;

public enum SchoologyResponseStatusEnum implements SchoologyResponseStatus
{
	SUCCESS_OK(200, "OK"),
	SUCCESS_CREATED(201, "Create"),
	SUCCESS_NO_CONTENT(204, "No content"),
	
	PERMISSION(403, "Insufficient permission level"),
	NOT_FOUND(404, "Resource not found");
	
	private final int code;
	private final String message;
	
	private SchoologyResponseStatusEnum(int code, String message)
	{
		this.code = code;
		this.message = message;
	}
	
	@Override
	public int getCode()
	{
		return code;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
	
	@Override
	public boolean isSuccess()
	{
		return this.name().startsWith("SUCCESS");
	}
	
	public static SchoologyResponseStatus getStatus(int code)
	{
		for(SchoologyResponseStatusEnum status : values())
		{
			if(status.getCode() == code)
			{
				return status;
			}
		}
		return new BasicSchoologyResponseStatus(code, "Unknown status", false);
	}
}
