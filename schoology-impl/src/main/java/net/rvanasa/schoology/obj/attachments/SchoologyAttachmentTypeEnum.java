package net.rvanasa.schoology.obj.attachments;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/updates#Fields
 * attachment/type
 */
public enum SchoologyAttachmentTypeEnum
{
	
	@SerializedName(value="file")
	FILE("file"),
	@SerializedName(value="link")
	LINK("link"),
	@SerializedName(value="video")
	VIDEO("video"),
	@SerializedName(value="embed")
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
