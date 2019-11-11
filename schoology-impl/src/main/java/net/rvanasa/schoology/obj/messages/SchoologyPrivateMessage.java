package net.rvanasa.schoology.obj.messages;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/private-messaging
 */
@Getter
public class SchoologyPrivateMessage extends SchoologyReference<SchoologyPrivateMessage>
{
	
	@SerializedName(value="id")
	String ID;
	String subject;
	@SerializedName(value="recipient_ids")
	String recipientIDs;
	@SerializedName(value="last_updated")
	Date lastUpdated;
	String mid;
	@SerializedName(value="author_id")
	String authorID;
	SchoologyMessageStatus message_status;
	String message;
	
	SchoologyLinks links;
	
}
