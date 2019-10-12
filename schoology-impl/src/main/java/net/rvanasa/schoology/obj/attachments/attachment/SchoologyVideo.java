package net.rvanasa.schoology.obj.attachments.attachment;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api/retrieving-attachments#Video_Object
 */
@Getter
public class SchoologyVideo
{
	@SerializedName(value="id")
	String ID;
	String title;
	@SerializedName(value="url")
	String URL;
	String favicon;
	String thumbnail;
	
}
