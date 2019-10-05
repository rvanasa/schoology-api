package net.rvanasa.schoology.obj.albums;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album#create_2
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album#list
 * withcontent=1
 */
@Getter
public class SchoologyMediaAlbumContent
{
	
	@SerializedName(value="id")
	String ID;
	@SerializedName(value="album_id")
	String albumID;
	String type;
	String caption;
	@SerializedName(value="display_order")
	int displayOrder;
	Date created;
	@SerializedName(value="album_cover")
	boolean albumCover;
	@SerializedName(value="converted_url")
	String convertedURL;
	@SerializedName(value="converted_filesize")
	String convertedFilesize;
	@SerializedName(value="converted_md5_checksum")
	String convertedMD5Checksum;
	@SerializedName(value="content_url")
	String contentURL;
	@SerializedName(value="content_filesize")
	String contentFilesize;
	@SerializedName(value="content_md5_checksum")
	String contentMD5Checksum;
	@SerializedName(value="thumbnail_url")
	String thumbnailURL;
	@SerializedName(value="thumbnail_dimensions")
	String thumbnailDimensions;
	@SerializedName(value="content_dimensions")
	String contentDimensions;
	
}
