package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.obj.attachments.SchoologyConvertedStatusEnum;

public class SchoologyConvertedStatusAdapter implements JsonDeserializer<SchoologyConvertedStatusEnum>
{

	@Override
	public SchoologyConvertedStatusEnum deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return SchoologyConvertedStatusEnum.getConvertedStatus(json.getAsInt());
	}

}
