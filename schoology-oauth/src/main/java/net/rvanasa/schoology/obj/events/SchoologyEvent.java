package net.rvanasa.schoology.obj.events;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.impl.SchoologyRealmEnum;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/event
 */
@Getter
public class SchoologyEvent
{
	
	String id;
	String title;
	String description;
	Date start;
	boolean has_end;
	Date end;
	boolean all_day;
	boolean editable;
	SchoologyRSVPType rsvp;
	boolean comments_enabled;
	SchoologyEventType type;
	SchoologyRealmEnum realm;
	//Depends on realm
	String school_id;
	String group_id;
	String section_id;
	
	SchoologyLinks links;
	
}
