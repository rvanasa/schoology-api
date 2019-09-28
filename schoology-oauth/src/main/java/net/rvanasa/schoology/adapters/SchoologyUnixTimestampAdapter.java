package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class SchoologyUnixTimestampAdapter implements JsonDeserializer<Date>
{

	@Override
	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return new Date(json.getAsLong());
	}

}
