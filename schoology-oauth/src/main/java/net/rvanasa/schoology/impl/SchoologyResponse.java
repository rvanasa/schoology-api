package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.ISchoologyResponseStatus;
import net.rvanasa.schoology.exception.SchoologyException;

public class SchoologyResponse
{
	private final ISchoologyResponseStatus status;
	private final SchoologyResponseBody body;
	private final SchoologyResponseHeaders headers;
	
	public SchoologyResponse(ISchoologyResponseStatus status, SchoologyResponseBody body, SchoologyResponseHeaders headers)
	{
		this.status = status;
		this.body = body;
		this.headers = headers;
	}
	
	public ISchoologyResponseStatus getStatus()
	{
		return status;
	}
	
	public SchoologyResponseBody getBody()
	{
		return body;
	}
	
	public SchoologyResponseHeaders getHeaders()
	{
		return headers;
	}
	
	public SchoologyResponse requireSuccess()
	{
		if(!getStatus().isSuccess())
		{
			throw new SchoologyException(getStatus(), getBody().getRawData());
		}
		
		return this;
	}
}
