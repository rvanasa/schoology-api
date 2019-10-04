package net.rvanasa.schoology.obj.attachments.attachment;

import lombok.Getter;

/*
 * https://developers.schoology.com/api/retrieving-attachments#Video_Object
 */
@Getter
public class SchoologyVideo
{
	String id;
	String title;
	String url;
	String favicon;
	String thumbnail;
	
}
