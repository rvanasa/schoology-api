package net.rvanasa.schoology.impl;

import net.rvanasa.schoology.ISchoologyNodeParser;
import net.rvanasa.schoology.impl.json.JsonSchoologyResponseHandler;
import net.rvanasa.schoology.impl.xml.XmlSchoologyResponseHandler;

public enum SchoologyContentTypeEnum
{
	JSON("application/json", "JSON", JsonSchoologyResponseHandler.DEFAULT),
	XML("text/xml", "XML", XmlSchoologyResponseHandler.DEFAULT);
	
	private final String id;
	private final String name;
	private final ISchoologyNodeParser parser;
	
	private SchoologyContentTypeEnum(String id, String name, ISchoologyNodeParser parser)
	{
		this.id = id;
		this.name = name;
		this.parser = parser;
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public ISchoologyNodeParser getParser()
	{
		return parser;
	}
}
