package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.obj.courses.SchoologyCourseSubjectAreaEnum;

public class SchoologyCourseSubjectAreaAdapter implements JsonDeserializer<SchoologyCourseSubjectAreaEnum>
{

	@Override
	public SchoologyCourseSubjectAreaEnum deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return SchoologyCourseSubjectAreaEnum.getCourseSubjectArea(json.getAsInt());
	}

}
