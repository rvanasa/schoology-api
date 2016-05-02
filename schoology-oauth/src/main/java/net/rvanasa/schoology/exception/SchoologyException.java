package net.rvanasa.schoology.exception;

import net.rvanasa.schoology.SchoologyResponseStatus;

public class SchoologyException extends RuntimeException
{
	public SchoologyException(SchoologyResponseStatus status)
	{
		this(status, status.getMessage());
	}
	
	public SchoologyException(SchoologyResponseStatus status, String message)
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
