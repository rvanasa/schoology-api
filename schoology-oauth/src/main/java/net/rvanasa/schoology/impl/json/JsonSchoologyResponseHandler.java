package net.rvanasa.schoology.impl.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import net.rvanasa.schoology.SchoologyNode;
import net.rvanasa.schoology.SchoologyNodeParser;
import net.rvanasa.schoology.SchoologyResponse;
import net.rvanasa.schoology.SchoologyResponseHandler;

public class JsonSchoologyResponseHandler implements SchoologyResponseHandler<JsonElement>, SchoologyNodeParser
{
	public static final JsonSchoologyResponseHandler DEFAULT = new JsonSchoologyResponseHandler(new JsonParser());
	
	private final JsonParser parser;
	
	public JsonSchoologyResponseHandler(JsonParser parser)
	{
		this.parser = parser;
	}
	
	public JsonParser getJsonParser()
	{
		return parser;
	}
	
	@Override
	public JsonElement handleResponse(SchoologyResponse response)
	{
		return getJsonParser().parse(response.getBody().getRawData());
	}
	
	@Override
	public SchoologyNode parseNode(String input)
	{
		return new JsonSchoologyNode(getJsonParser().parse(input));
	}
}
