package net.rvanasa.schoology.obj.documents;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;
import net.rvanasa.schoology.obj.SchoologyReference;
import net.rvanasa.schoology.obj.attachments.SchoologyAttachments;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/documents
 */
@Getter
public class SchoologyDocument extends SchoologyReference<SchoologyDocument>
{
	
	@SerializedName(value="id")
	String ID;
	String title;
	@SerializedName(value="course_fid")
	String courseFID;
	boolean available;
	boolean published;
	@SerializedName(value="completion_status")
	String completionStatus;
	boolean completed;
	SchoologyAttachments attachments;
	
	SchoologyLinks links;
	
}
