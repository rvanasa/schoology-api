package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.SchoologyNode;

public class SchoologyResponseBody
{
	private final SchoologyContentTypeEnum contentType;
	private final String rawData;

	public SchoologyResponseBody(SchoologyContentTypeEnum contentType, String rawData)
	{
		this.contentType = contentType;
		this.rawData = rawData;	
	}
	
	public SchoologyContentTypeEnum getContentType()
	{
		return contentType;
	}
	
	public String getRawData()
	{
		return rawData;
	}
	
	public SchoologyNode parse()
	{
		return getContentType().getParser().parseNode(getRawData());
	}
}
