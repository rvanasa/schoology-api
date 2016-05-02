package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.SchoologyContentType;
import net.rvanasa.schoology.SchoologyResponseBody;

public class BasicSchoologyResponseBody implements SchoologyResponseBody
{
	private final SchoologyContentType contentType;
	private final String rawData;

	public BasicSchoologyResponseBody(SchoologyContentType contentType, String rawData)
	{
		this.contentType = contentType;
		this.rawData = rawData;
	}
	
	@Override
	public SchoologyContentType getContentType()
	{
		return contentType;
	}
	
	@Override
	public String getRawData()
	{
		return rawData;
	}
}
