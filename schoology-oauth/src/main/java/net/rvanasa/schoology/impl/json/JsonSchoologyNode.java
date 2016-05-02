package net.rvanasa.schoology.impl.json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;

import net.rvanasa.schoology.SchoologyNode;

public class JsonSchoologyNode implements SchoologyNode
{
	public static final JsonSchoologyNode NULL = new JsonSchoologyNode(null);
	
	private final JsonElement element;
	
	public JsonSchoologyNode(JsonElement element)
	{
		if(element == null)
		{
			element = JsonNull.INSTANCE;
		}
		
		this.element = element;
	}
	
	public JsonElement getElement()
	{
		return element;
	}
	
	@Override
	public SchoologyNode get(String key)
	{
		return asMapValue().getOrDefault(key, NULL);
	}
	
	@Override
	public SchoologyNode get(int index)
	{
		SchoologyNode node = asListValue().get(index);
		return node != null ? node : NULL;
	}
	
	@Override
	public boolean isNull()
	{
		return getElement().isJsonNull();
	}
	
	@Override
	public boolean isEmpty()
	{
		if(isNull())
		{
			return true;
		}
		else if(getElement().isJsonArray())
		{
			return getElement().getAsJsonArray().size() == 0;
		}
		else if(getElement().isJsonObject())
		{
			return getElement().getAsJsonObject().entrySet().size() == 0;
		}
		else
		{
			return getElement().getAsString().isEmpty();
		}
	}
	
	@Override
	public boolean isContainer()
	{
		return !getElement().isJsonPrimitive();
	}
	
	@Override
	public boolean isListValue()
	{
		return getElement().isJsonArray();
	}
	
	@Override
	public boolean isMapValue()
	{
		return getElement().isJsonObject();
	}
	
	@Override
	public Map<String, SchoologyNode> asMapValue()
	{
		Map<String, SchoologyNode> map = new LinkedHashMap<>();
		
		if(getElement().isJsonObject())
		{
			for(Entry<String, JsonElement> prop : getElement().getAsJsonObject().entrySet())
			{
				map.put(prop.getKey(), new JsonSchoologyNode(prop.getValue()));
			}
		}
		else if(getElement().isJsonArray())
		{
			int i = 0;
			for(JsonElement element : getElement().getAsJsonArray())
			{
				map.put(String.valueOf(i++), new JsonSchoologyNode(element));
			}
		}
		
		return map;
	}
	
	@Override
	public List<SchoologyNode> asListValue()
	{
		List<SchoologyNode> list = new ArrayList<>();
		
		if(getElement().isJsonArray())
		{
			for(JsonElement element : getElement().getAsJsonArray())
			{
				list.add(new JsonSchoologyNode(element));
			}
		}
		else if(getElement().isJsonObject())
		{
			for(Entry<String, JsonElement> prop : getElement().getAsJsonObject().entrySet())
			{
				list.add(new JsonSchoologyNode(prop.getValue()));
			}
		}
		else if(!getElement().isJsonNull())
		{
			list.add(this);
		}
		
		return list;
	}
	
	@Override
	public String asRawData()
	{
		return getElement().toString();
	}
	
	@Override
	public String asString()
	{
		return getElement().getAsString();
	}
	
	@Override
	public boolean asBoolean()
	{
		return getElement().getAsBoolean() || !getElement().toString().equals("0");
	}
	
	@Override
	public Number asNumber()
	{
		return getElement().getAsNumber();
	}
	
	@Override
	public String toString()
	{
		return getClass().getSimpleName() + "(" + asRawData() + ")";
	}
}
