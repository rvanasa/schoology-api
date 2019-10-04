package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.obj.attachments.SchoologyAttachmentTypeEnum;

public class SchoologyAttachmentTypeAdapter implements JsonDeserializer<SchoologyAttachmentTypeEnum>
{

	@Override
	public SchoologyAttachmentTypeEnum deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return SchoologyAttachmentTypeEnum.getAttachmentType(json.getAsString());
	}

}
