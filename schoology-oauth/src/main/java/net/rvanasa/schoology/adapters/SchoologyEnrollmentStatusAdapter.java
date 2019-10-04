package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.obj.enrollment.SchoologyEnrollmentStatus;

public class SchoologyEnrollmentStatusAdapter implements JsonDeserializer<SchoologyEnrollmentStatus>
{

	@Override
	public SchoologyEnrollmentStatus deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		return SchoologyEnrollmentStatus.getEnrollmentStatus(json.getAsInt());
	}

}
