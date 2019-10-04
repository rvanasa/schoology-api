package net.rvanasa.schoology.exception;

import net.rvanasa.schoology.ISchoologyResponseStatus;

public class SchoologyException extends RuntimeException
{
	public SchoologyException(ISchoologyResponseStatus status)
	{
		this(status, status.getMessage());
	}
	
	public SchoologyException(ISchoologyResponseStatus status, String message)
	{
		this("Response code " + status.getCode() + ": " + message.replaceAll("\n+", " "));
	}
	
	public SchoologyException(String message)
	{
		super(message);
	}
	
	public SchoologyException(Throwable e)
	{
		super(e);
	}
	
	public SchoologyException(String message, Throwable e)
	{
		super(message, e);
	}
}
