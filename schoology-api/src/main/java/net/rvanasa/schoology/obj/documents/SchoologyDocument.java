package net.rvanasa.schoology.obj.documents;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.attachments.SchoologyAttachments;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/documents
 */
@Getter
public class SchoologyDocument
{
	
	String id;
	String title;
	String course_fid;
	boolean available;
	boolean published;
	String completion_status;
	boolean completed;
	SchoologyAttachments attachments;
	
	SchoologyLinks links;
	
}
