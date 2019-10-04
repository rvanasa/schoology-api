package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.ISchoologyResponse;
import net.rvanasa.schoology.ISchoologyResponseBody;
import net.rvanasa.schoology.ISchoologyResponseHeaders;
import net.rvanasa.schoology.ISchoologyResponseStatus;
import net.rvanasa.schoology.exception.SchoologyException;

public class BasicSchoologyResponse implements ISchoologyResponse
{
	private final ISchoologyResponseStatus status;
	private final ISchoologyResponseBody body;
	private final ISchoologyResponseHeaders headers;
	
	public BasicSchoologyResponse(ISchoologyResponseStatus status, ISchoologyResponseBody body, ISchoologyResponseHeaders headers)
	{
		this.status = status;
		this.body = body;
		this.headers = headers;
	}
	
	@Override
	public ISchoologyResponseStatus getStatus()
	{
		return status;
	}
	
	@Override
	public ISchoologyResponseBody getBody()
	{
		return body;
	}
	
	@Override
	public ISchoologyResponseHeaders getHeaders()
	{
		return headers;
	}
	
	@Override
	public ISchoologyResponse requireSuccess()
	{
		if(!getStatus().isSuccess())
		{
			throw new SchoologyException(getStatus(), getBody().getRawData());
		}
		
		return this;
	}
}
