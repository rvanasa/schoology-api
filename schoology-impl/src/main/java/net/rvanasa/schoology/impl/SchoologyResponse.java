package net.rvanasa.schoology.impl;

import lombok.Getter;
import net.rvanasa.schoology.exception.SchoologyException;

public class SchoologyResponse
{
	@Getter
	private final SchoologyResponseStatusEnum status;
	@Getter
	private final SchoologyResponseBody body;
	@Getter
	private final SchoologyResponseHeaders headers;
	
	public SchoologyResponse(SchoologyResponseStatusEnum status, SchoologyResponseBody body, SchoologyResponseHeaders headers)
	{
		this.status = status;
		this.body = body;
		this.headers = headers;
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
