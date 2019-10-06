package net.rvanasa.schoology.obj.albums;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album
 */
@Getter
public class SchoologyMediaAlbums
{
	
	SchoologyMediaAlbum[] album;
	int total;
	
	SchoologyLinks links;
	
}
