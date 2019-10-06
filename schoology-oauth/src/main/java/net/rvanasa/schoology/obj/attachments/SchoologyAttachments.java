package net.rvanasa.schoology.obj.attachments;

import lombok.Getter;
import net.rvanasa.schoology.obj.attachments.attachment.SchoologyEmbed;
import net.rvanasa.schoology.obj.attachments.attachment.SchoologyFile;
import net.rvanasa.schoology.obj.attachments.attachment.SchoologyLink;
import net.rvanasa.schoology.obj.attachments.attachment.SchoologyVideo;

/*
 * https://developers.schoology.com/api/retrieving-attachments
 * Attachments object
 */
@Getter
public class SchoologyAttachments
{
	
	SchoologyFile[] files;
	SchoologyLink[] links;
	SchoologyVideo[] videos;
	SchoologyEmbed[] embeds;
	
}
