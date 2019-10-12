package net.rvanasa.schoology.impl.xml;

import org.json.XML;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import net.rvanasa.schoology.ISchoologyNodeParser;
import net.rvanasa.schoology.ISchoologyResponseHandler;
import net.rvanasa.schoology.impl.SchoologyResponse;
import net.rvanasa.schoology.impl.json.JsonSchoologyNode;

public class XmlSchoologyResponseHandler implements ISchoologyResponseHandler<JsonElement>, ISchoologyNodeParser
{
	public static final XmlSchoologyResponseHandler DEFAULT = new XmlSchoologyResponseHandler();
	
	@Override
	public JsonElement handleResponse(SchoologyResponse response)
	{
		//Convert XML response to JSON
		return JsonParser.parseString(xmlToJSON(response.getBody().getRawData()));
	}
	
	@Override
	public JsonSchoologyNode parseNode(String input)
	{
		return new JsonSchoologyNode(JsonParser.parseString(xmlToJSON(input)));
	}
	
	private String xmlToJSON(String raw)
	{
		return XML.toJSONObject(raw).getJSONObject("result").toString();
	}
}
