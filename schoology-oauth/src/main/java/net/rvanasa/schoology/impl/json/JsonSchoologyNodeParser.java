package net.rvanasa.schoology.impl.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import net.rvanasa.schoology.SchoologyNode;
import net.rvanasa.schoology.SchoologyNodeParser;

public class JsonSchoologyNodeParser implements SchoologyNodeParser
{
	private final JsonParser parser = new JsonParser();
	
	public JsonParser getParser()
	{
		return parser;
	}
	
	@Override
	public SchoologyNode parse(String input)
	{
		JsonElement element = getParser().parse(input);
		
		return new JsonSchoologyNode(element);
	}
}
