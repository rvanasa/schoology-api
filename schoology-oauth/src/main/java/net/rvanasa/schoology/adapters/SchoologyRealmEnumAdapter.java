package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.SchoologyRealmEnum;

public class SchoologyRealmEnumAdapter implements JsonDeserializer<SchoologyRealmEnum>
{

	@Override
	public SchoologyRealmEnum deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return SchoologyRealmEnum.getRealm(json.getAsString());
	}

}
