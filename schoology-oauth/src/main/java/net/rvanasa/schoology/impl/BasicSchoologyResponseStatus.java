package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.SchoologyResponseStatus;

public class BasicSchoologyResponseStatus implements SchoologyResponseStatus
{
	private final int code;
	private final String message;
	private final boolean success;
	
	public BasicSchoologyResponseStatus(int code, String message, boolean success)
	{
		this.code = code;
		this.message = message;
		this.success = success;
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
		return success;
	}
}
