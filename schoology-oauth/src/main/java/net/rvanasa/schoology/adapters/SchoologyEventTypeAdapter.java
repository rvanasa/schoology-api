package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.obj.events.SchoologyEventType;

public class SchoologyEventTypeAdapter implements JsonDeserializer<SchoologyEventType>
{

	@Override
	public SchoologyEventType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return SchoologyEventType.getEventType(json.getAsString());
	}

}
