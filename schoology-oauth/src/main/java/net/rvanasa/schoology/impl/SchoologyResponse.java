package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.exception.SchoologyException;

public class SchoologyResponse
{
	private final SchoologyResponseStatusEnum status;
	private final SchoologyResponseBody body;
	private final SchoologyResponseHeaders headers;
	
	public SchoologyResponse(SchoologyResponseStatusEnum status, SchoologyResponseBody body, SchoologyResponseHeaders headers)
	{
		this.status = status;
		this.body = body;
		this.headers = headers;
	}
	
	public SchoologyResponseStatusEnum getStatus()
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
