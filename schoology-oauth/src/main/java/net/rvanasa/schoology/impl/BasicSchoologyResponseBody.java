package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.ISchoologyContentType;
import net.rvanasa.schoology.ISchoologyNode;

public class BasicSchoologyResponseBody
{
	private final ISchoologyContentType contentType;
	private final String rawData;

	public BasicSchoologyResponseBody(ISchoologyContentType contentType, String rawData)
	{
		this.contentType = contentType;
		this.rawData = rawData;	
	}
	
	public ISchoologyContentType getContentType()
	{
		return contentType;
	}
	
	public String getRawData()
	{
		return rawData;
	}
	
	public ISchoologyNode parse()
	{
		return getContentType().getParser().parseNode(getRawData());
	}
}
