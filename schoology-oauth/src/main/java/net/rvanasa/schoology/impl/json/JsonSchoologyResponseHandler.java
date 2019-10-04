package net.rvanasa.schoology.impl.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import net.rvanasa.schoology.ISchoologyNode;
import net.rvanasa.schoology.ISchoologyNodeParser;
import net.rvanasa.schoology.ISchoologyResponse;
import net.rvanasa.schoology.ISchoologyResponseHandler;

public class JsonSchoologyResponseHandler implements ISchoologyResponseHandler<JsonElement>, ISchoologyNodeParser
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
	public JsonElement handleResponse(ISchoologyResponse response)
	{
		return getJsonParser().parse(response.getBody().getRawData());
	}
	
	@Override
	public ISchoologyNode parseNode(String input)
	{
		return new JsonSchoologyNode(getJsonParser().parse(input));
	}
}
