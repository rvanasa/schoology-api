package net.rvanasa.schoology.exception;

import net.rvanasa.schoology.impl.SchoologyResponseStatusEnum;

@SuppressWarnings("serial")
public class SchoologyException extends RuntimeException
{
	public SchoologyException(SchoologyResponseStatusEnum status)
	{
		this(status, status.getMessage());
	}
	
	public SchoologyException(SchoologyResponseStatusEnum status, String message)
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
