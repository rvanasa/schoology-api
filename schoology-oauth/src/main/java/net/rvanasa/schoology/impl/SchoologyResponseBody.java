package net.rvanasa.schoology.impl;

import lombok.Getter;
import net.rvanasa.schoology.SchoologyNode;

public class SchoologyResponseBody
{
	@Getter
	private final SchoologyContentTypeEnum contentType;
	@Getter
	private final String rawData;

	public SchoologyResponseBody(SchoologyContentTypeEnum contentType, String rawData)
	{
		this.contentType = contentType;
		this.rawData = rawData;	
	}
	
	public SchoologyNode parse()
	{
		return getContentType().getParser().parseNode(getRawData());
	}
}
