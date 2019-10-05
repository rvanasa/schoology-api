package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.ISchoologyResponseStatus;

public enum SchoologyResponseStatusEnum implements ISchoologyResponseStatus
{
	SUCCESS_OK(200, "OK"),
	SUCCESS_CREATED(201, "Create"),
	SUCCESS_NO_CONTENT(204, "No content"),
	
	UNAUTHORIZED(401, "Unauthorized"),
	PERMISSION(403, "Insufficient permission level"),
	NOT_FOUND(404, "Resource not found"),
	NOT_ALLOWED(405, "Method not allowed");
	
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
	
	public static ISchoologyResponseStatus getStatus(int code)
	{
		for(SchoologyResponseStatusEnum status : values())
		{
			if(status.getCode() == code)
			{
				return status;
			}
		}
		return new SchoologyResponseStatus(code, "Unknown status", false);
	}
}
