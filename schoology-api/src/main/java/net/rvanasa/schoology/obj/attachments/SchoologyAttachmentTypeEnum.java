package net.rvanasa.schoology.obj.attachments;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/updates#Fields
 * attachment/type
 */
public enum SchoologyAttachmentTypeEnum
{
	
	FILE("file"),
	LINK("link"),
	VIDEO("video"),
	EMBED("embed");
	
	@Getter
	private final String apiVaule;
	
	private SchoologyAttachmentTypeEnum(String apiValue)
	{
		this.apiVaule = apiValue;
	}
	
	public static SchoologyAttachmentTypeEnum getAttachmentType(String apiValue)
	{
		for(SchoologyAttachmentTypeEnum type : values()) if(type.apiVaule.equalsIgnoreCase(apiValue)) return type;
		
		return null;
	}
	
}
