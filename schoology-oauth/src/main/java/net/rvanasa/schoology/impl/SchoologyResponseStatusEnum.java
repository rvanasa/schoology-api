package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.SchoologyResponseStatus;

public enum SchoologyResponseStatusEnum implements SchoologyResponseStatus
{
	SUCCESS(200, "OK"),
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
		return this == SUCCESS;
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
