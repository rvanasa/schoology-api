package net.rvanasa.schoology.obj.attachments;

import lombok.Getter;
import net.rvanasa.schoology.obj.attachments.attachment.SchoologyEmbedWrapper;
import net.rvanasa.schoology.obj.attachments.attachment.SchoologyFileWrapper;
import net.rvanasa.schoology.obj.attachments.attachment.SchoologyLinkWrapper;
import net.rvanasa.schoology.obj.attachments.attachment.SchoologyVideoWrapper;

/*
 * https://developers.schoology.com/api/retrieving-attachments
 * Attachments object
 */
@Getter
public class SchoologyAttachments
{
	
	SchoologyFileWrapper files;
	SchoologyLinkWrapper links;
	SchoologyVideoWrapper videos;
	SchoologyEmbedWrapper embeds;
	
}
