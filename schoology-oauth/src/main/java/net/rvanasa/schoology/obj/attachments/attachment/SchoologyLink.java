package net.rvanasa.schoology.obj.attachments.attachment;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api/retrieving-attachments#Link_Object
 */
@Getter
public class SchoologyLink
{
	@SerializedName(value="id")
	String ID;
	String title;
	@SerializedName(value="url")
	String URL;
	String summary;
	String favicon;
	String thumbnail;
	
}
