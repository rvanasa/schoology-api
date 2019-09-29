package net.rvanasa.schoology.obj.attachments.attachment;

import java.util.Date;

import lombok.Getter;
import net.rvanasa.schoology.obj.attachments.SchoologyConvertedStatusEnum;
import net.rvanasa.schoology.obj.attachments.SchoologyConvertedTypeEnum;

/*
 * https://developers.schoology.com/api/retrieving-attachments#File_Object
 */
@Getter
public class SchoologyFile
{
	
	String id;
	String title;
	String filename;
	String md5_checksum;
	Date timestamp;
	String download_path;
	String extension;
	SchoologyConvertedStatusEnum converted_status;
	SchoologyConvertedTypeEnum converted_type;
	//Converted information is only given for audio and video files
	String converted_filename;
	String converted_download_path;
	String converted_extension;
	int converted_filesize;
	String converted_md5_checksum;
	
}
