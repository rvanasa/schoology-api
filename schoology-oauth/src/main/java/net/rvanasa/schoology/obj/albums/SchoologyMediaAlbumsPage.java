package net.rvanasa.schoology.obj.albums;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyPage;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/media-album
 */
@Getter
public class SchoologyMediaAlbumsPage extends SchoologyPage<SchoologyMediaAlbumsPage>
{
	
	SchoologyMediaAlbum[] album;
	
}
