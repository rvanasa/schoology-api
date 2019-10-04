package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.ISchoologyContentType;
import net.rvanasa.schoology.ISchoologyNodeParser;
import net.rvanasa.schoology.impl.json.JsonSchoologyResponseHandler;

public enum SchoologyContentTypeEnum implements ISchoologyContentType
{
	JSON("application/json", "JSON", JsonSchoologyResponseHandler.DEFAULT),
	XML("text/xml", "XML", null);
	
	private final String id;
	private final String name;
	private final ISchoologyNodeParser parser;
	
	private SchoologyContentTypeEnum(String id, String name, ISchoologyNodeParser parser)
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
	public ISchoologyNodeParser getParser()
	{
		return parser;
	}
}
