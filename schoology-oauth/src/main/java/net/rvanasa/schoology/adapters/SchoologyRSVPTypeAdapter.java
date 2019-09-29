package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.obj.events.SchoologyRSVPType;

public class SchoologyRSVPTypeAdapter implements JsonDeserializer<SchoologyRSVPType>
{

	@Override
	public SchoologyRSVPType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return SchoologyRSVPType.getRSVPType(json.getAsInt());
	}

}
