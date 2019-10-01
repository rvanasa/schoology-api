package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.obj.users.SchoologyGenderEnum;

public class SchoologyGenderAdapter implements JsonDeserializer<SchoologyGenderEnum>
{

	@Override
	public SchoologyGenderEnum deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return SchoologyGenderEnum.getGender(json.getAsString());
	}

}