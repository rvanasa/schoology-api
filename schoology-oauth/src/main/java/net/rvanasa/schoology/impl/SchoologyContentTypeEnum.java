package net.rvanasa.schoology.impl;

import lombok.Getter;
import net.rvanasa.schoology.ISchoologyNodeParser;
import net.rvanasa.schoology.impl.json.JsonSchoologyResponseHandler;
import net.rvanasa.schoology.impl.xml.XmlSchoologyResponseHandler;

public enum SchoologyContentTypeEnum
{
	JSON("application/json", "JSON", JsonSchoologyResponseHandler.DEFAULT),
	XML("text/xml", "XML", XmlSchoologyResponseHandler.DEFAULT);
	
	@Getter
	private final String id;
	@Getter
	private final String name;
	@Getter
	private final ISchoologyNodeParser parser;
	
	private SchoologyContentTypeEnum(String id, String name, ISchoologyNodeParser parser)
	{
		this.id = id;
		this.name = name;
		this.parser = parser;
	}
	
}
