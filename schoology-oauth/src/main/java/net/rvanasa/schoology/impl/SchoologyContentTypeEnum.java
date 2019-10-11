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
	private final String ID;
	@Getter
	private final String name;
	@Getter
	private final ISchoologyNodeParser parser;
	
	private SchoologyContentTypeEnum(String ID, String name, ISchoologyNodeParser parser)
	{
		this.ID = ID;
		this.name = name;
		this.parser = parser;
	}
	
}
