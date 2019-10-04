package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.ISchoologyContentType;
import net.rvanasa.schoology.ISchoologyResponseBody;

public class BasicSchoologyResponseBody implements ISchoologyResponseBody
{
	private final ISchoologyContentType contentType;
	private final String rawData;

	public BasicSchoologyResponseBody(ISchoologyContentType contentType, String rawData)
	{
		this.contentType = contentType;
		this.rawData = rawData;
	}
	
	@Override
	public ISchoologyContentType getContentType()
	{
		return contentType;
	}
	
	@Override
	public String getRawData()
	{
		return rawData;
	}
}
