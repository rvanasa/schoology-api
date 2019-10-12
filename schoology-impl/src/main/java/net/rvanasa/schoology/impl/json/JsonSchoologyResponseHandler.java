package net.rvanasa.schoology.impl.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import net.rvanasa.schoology.ISchoologyNodeParser;
import net.rvanasa.schoology.ISchoologyResponseHandler;
import net.rvanasa.schoology.impl.SchoologyResponse;

public class JsonSchoologyResponseHandler implements ISchoologyResponseHandler<JsonElement>, ISchoologyNodeParser
{
	public static final JsonSchoologyResponseHandler DEFAULT = new JsonSchoologyResponseHandler();
	
	@Override
	public JsonElement handleResponse(SchoologyResponse response)
	{
		return JsonParser.parseString(response.getBody().getRawData());
	}
	
	@Override
	public JsonSchoologyNode parseNode(String input)
	{
		return new JsonSchoologyNode(JsonParser.parseString(input));
	}
}
