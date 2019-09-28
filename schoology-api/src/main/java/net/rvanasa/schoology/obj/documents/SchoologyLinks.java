package net.rvanasa.schoology.obj.documents;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/documents
 */
@Getter
public class SchoologyLinks {
	
	//TODO: Add file and video objects
	SchoologyLinks[] link;	
	
}

@Getter
class SchoologyLink {
	
	String id;
	//Type is "link"
	String type;
	String url;
	String title;
	String summary;
	String display_inline;
	
}
