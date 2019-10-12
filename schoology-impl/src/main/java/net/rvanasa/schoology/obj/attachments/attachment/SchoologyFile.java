package net.rvanasa.schoology.obj.attachments.attachment;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.attachments.SchoologyConvertedStatusEnum;
import net.rvanasa.schoology.obj.attachments.SchoologyConvertedTypeEnum;

/*
 * https://developers.schoology.com/api/retrieving-attachments#File_Object
 */
@Getter
public class SchoologyFile
{
	
	@SerializedName(value="id")
	String ID;
	String title;
	String filename;
	@SerializedName(value="md5_checksum")
	String md5Checksum;
	Date timestamp;
	@SerializedName(value="download_path")
	String downloadPath;
	String extension;
	@SerializedName(value="converted_status")
	SchoologyConvertedStatusEnum convertedStatus;
	@SerializedName(value="converted_type")
	SchoologyConvertedTypeEnum convertedType;
	//Converted information is only given for audio and video files
	@SerializedName(value="converted_filename")
	String convertedFilename;
	@SerializedName(value="converted_download_path")
	String convertedDownloadPath;
	@SerializedName(value="converted_extension")
	String convertedExtension;
	@SerializedName(value="converted_filesize")
	int convertedFilesize;
	@SerializedName(value="converted_md5_checksum")
	String convertedMD5Checksum;
	
}
