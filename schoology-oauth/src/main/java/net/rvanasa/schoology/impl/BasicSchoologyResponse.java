package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.ISchoologyResponseStatus;
import net.rvanasa.schoology.exception.SchoologyException;

public class BasicSchoologyResponse
{
	private final ISchoologyResponseStatus status;
	private final BasicSchoologyResponseBody body;
	private final BasicSchoologyResponseHeaders headers;
	
	public BasicSchoologyResponse(ISchoologyResponseStatus status, BasicSchoologyResponseBody body, BasicSchoologyResponseHeaders headers)
	{
		this.status = status;
		this.body = body;
		this.headers = headers;
	}
	
	public ISchoologyResponseStatus getStatus()
	{
		return status;
	}
	
	public BasicSchoologyResponseBody getBody()
	{
		return body;
	}
	
	public BasicSchoologyResponseHeaders getHeaders()
	{
		return headers;
	}
	
	public BasicSchoologyResponse requireSuccess()
	{
		if(!getStatus().isSuccess())
		{
			throw new SchoologyException(getStatus(), getBody().getRawData());
		}
		
		return this;
	}
}
