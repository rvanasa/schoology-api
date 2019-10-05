package net.rvanasa.schoology.obj.events;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.impl.SchoologyRealmEnum;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/event
 */
@Getter
public class SchoologyEvent
{
	
	@SerializedName(value="id")
	String ID;
	String title;
	String description;
	Date start;
	@SerializedName(value="has_end")
	boolean hasEnd;
	Date end;
	@SerializedName(value="all_day")
	boolean allDay;
	boolean editable;
	SchoologyRSVPType rsvp;
	@SerializedName(value="comments_enabled")
	boolean commentsEnabled;
	SchoologyEventType type;
	SchoologyRealmEnum realm;
	//Depends on realm
	@SerializedName(value="school_id")
	String schoolID;
	@SerializedName(value="group_id")
	String groupID;
	@SerializedName(value="section_id")
	String sectionID;
	
	SchoologyLinks links;
	
}
