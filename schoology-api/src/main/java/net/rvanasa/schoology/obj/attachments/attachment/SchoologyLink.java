package net.rvanasa.schoology.obj.attachments.attachment;

import lombok.Getter;

/*
 * https://developers.schoology.com/api/retrieving-attachments#Link_Object
 */
@Getter
public class SchoologyLink
{
	String id;
	String title;
	String url;
	String summary;
	String favicon;
	String thumbnail;
	
}
