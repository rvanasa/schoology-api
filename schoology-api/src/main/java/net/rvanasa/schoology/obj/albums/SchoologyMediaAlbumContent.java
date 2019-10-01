package net.rvanasa.schoology.obj.albums;

import java.util.Date;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album#create_2
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album#list
 * withcontent=1
 */
@Getter
public class SchoologyMediaAlbumContent
{
	
	String id;
	String album_id;
	String type;
	String caption;
	int display_order;
	Date created;
	boolean album_cover;
	String converted_url;
	String converted_filesize;
	String converted_md5_checksum;
	String content_url;
	String content_filesize;
	String content_md5_checksum;
	String thumbnail_url;
	String thumbnail_dimensions;
	String content_dimensions;
	
}
