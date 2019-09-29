package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.obj.attachments.SchoologyConvertedTypeEnum;

public class SchoologyConvertedTypeAdapter implements JsonDeserializer<SchoologyConvertedTypeEnum>
{

	@Override
	public SchoologyConvertedTypeEnum deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return SchoologyConvertedTypeEnum.getConvertedType(json.getAsInt());
	}

}
