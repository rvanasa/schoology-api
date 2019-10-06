package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class BooleanAdapter implements JsonDeserializer<Boolean>
{

	@Override
	public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		
		String value = json.getAsString();
		
		try {
			int i = Integer.parseInt(value);
			
			return i == 0 ? false : i == 1 ? true : null;
		} catch (Exception e) {
			return value.equalsIgnoreCase("false") ? false : value.equalsIgnoreCase("true") ? true : null;
		}
        
	}

}
