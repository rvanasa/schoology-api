package net.rvanasa.schoology.obj.messages;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyPage;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/private-messaging
 * Represents a page of private messages
 */
@Getter
public class SchoologyPrivateMessagesPage extends SchoologyPage<SchoologyPrivateMessagesPage>
{
	
	@SerializedName(value="message")
	SchoologyPrivateMessage[] messages;
	
}
