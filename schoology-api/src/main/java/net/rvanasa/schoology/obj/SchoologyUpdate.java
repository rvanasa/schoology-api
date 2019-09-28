package net.rvanasa.schoology.obj;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.obj.documents.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/updates
 */
@Getter
public class SchoologyUpdate {
	
	String id;
	String body;
	String uid;
	Date created;
	Date last_updated;
	String realm;
	
	//Only one of these variables will be used depending on the realm
	String user_id;
	String section_id;
	String building_id;
	
	int num_comments;
	
	SchoologyAttachments attachments;
	
	//TODO: Untested
	SchoologyPoll polls;
	
	
	
}

@Getter
class SchoologyAttachments{
	
	SchoologyLinks links;
	
}

@Getter
class SchoologyPoll {
	
	SchoologyPollOptions[] poll;
	
}

@Getter
class SchoologyPollOptions{
	
	String title;
	int count;
	boolean selected;
	
}