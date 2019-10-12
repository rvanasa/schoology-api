package net.rvanasa.schoology.obj.attachments;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api/retrieving-attachments#The_tags_Object
 */
@Getter
public class SchoologyTag
{
	
	String title;
	String description;
	@SerializedName(value="id")
	String ID;
	@SerializedName(value="vid")
	String VID;
	
}
