package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class SchoologyBooleanAdapter implements JsonDeserializer<Boolean>
{

	@Override
	public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		
		byte value = json.getAsByte();
		
        return value == 0 ? false : value == 1 ? true : null;
	}

}
