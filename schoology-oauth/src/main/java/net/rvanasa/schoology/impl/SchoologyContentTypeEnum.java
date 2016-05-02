package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.SchoologyContentType;
import net.rvanasa.schoology.SchoologyNodeParser;
import net.rvanasa.schoology.impl.json.JsonSchoologyResponseHandler;

public enum SchoologyContentTypeEnum implements SchoologyContentType
{
	JSON("application/json", "JSON", JsonSchoologyResponseHandler.DEFAULT),
	XML("text/xml", "XML", null);
	
	private final String id;
	private final String name;
	private final SchoologyNodeParser parser;
	
	private SchoologyContentTypeEnum(String id, String name, SchoologyNodeParser parser)
	{
		this.id = id;
		this.name = name;
		this.parser = parser;
	}
	
	@Override
	public String getID()
	{
		return id;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public SchoologyNodeParser getParser()
	{
		return parser;
	}
}
