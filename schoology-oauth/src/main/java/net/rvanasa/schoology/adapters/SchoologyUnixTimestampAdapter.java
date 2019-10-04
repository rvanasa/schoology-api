package net.rvanasa.schoology.adapters;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class SchoologyUnixTimestampAdapter implements JsonDeserializer<Date>
{
	
	private final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
	
	@Override
	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
			throws JsonParseException {
		
		String raw = json.getAsString();
		
		try {
			//Assume unix time
			long l = Long.parseLong(raw);
			
			return new Date(l);
		} catch (Exception e) {
			//Assume datetime format
			try {
				return dateTimeFormat.parse(raw);
			} catch (ParseException e1) {
				return null;
			}
		}
		
	}

}
