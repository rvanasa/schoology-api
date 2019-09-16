package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.SchoologyResponse;
import net.rvanasa.schoology.SchoologyResponseBody;
import net.rvanasa.schoology.SchoologyResponseHeaders;
import net.rvanasa.schoology.SchoologyResponseStatus;
import net.rvanasa.schoology.exception.SchoologyException;

public class BasicSchoologyResponse implements SchoologyResponse
{
	private final SchoologyResponseStatus status;
	private final SchoologyResponseBody body;
	private final SchoologyResponseHeaders headers;
	
	public BasicSchoologyResponse(SchoologyResponseStatus status, SchoologyResponseBody body, SchoologyResponseHeaders headers)
	{
		this.status = status;
		this.body = body;
		this.headers = headers;
	}
	
	@Override
	public SchoologyResponseStatus getStatus()
	{
		return status;
	}
	
	@Override
	public SchoologyResponseBody getBody()
	{
		return body;
	}
	
	@Override
	public SchoologyResponseHeaders getHeaders()
	{
		return headers;
	}
	
	@Override
	public SchoologyResponse requireSuccess()
	{
		if(!getStatus().isSuccess())
		{
			throw new SchoologyException(getStatus(), getBody().getRawData());
		}
		
		return this;
	}
}
