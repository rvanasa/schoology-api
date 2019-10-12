package net.rvanasa.schoology.obj.attachments.attachment;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api/retrieving-attachments#Embed_Object
 */
@Getter
public class SchoologyEmbed
{
	@SerializedName(value="id")
	String ID;
	@SerializedName(value="embed_code")
	String embedCode;
	
}
