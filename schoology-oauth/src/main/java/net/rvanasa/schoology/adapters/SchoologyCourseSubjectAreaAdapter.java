package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import net.rvanasa.schoology.realms.courses.SchoologyCourseSubjectAreaEnum;

public class SchoologyCourseSubjectAreaAdapter implements JsonDeserializer<SchoologyCourseSubjectAreaEnum>{

	@Override
	public SchoologyCourseSubjectAreaEnum deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		SchoologyCourseSubjectAreaEnum[] scopes = SchoologyCourseSubjectAreaEnum.values();
		
		int apiValue = json.getAsInt();
		
		for(SchoologyCourseSubjectAreaEnum scope : scopes) {
			if(scope.getApiVaule() == apiValue) return scope;
		}
		
		return null;
	}

}
