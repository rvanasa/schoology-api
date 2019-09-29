package net.rvanasa.schoology.obj.attachments;

import lombok.Getter;

/*
 * https://developers.schoology.com/api/retrieving-attachments#File_Object
 */
public enum SchoologyConvertedTypeEnum
{
	
	VIDEO(1, "Video"),
	AUDIO(2, "Audio"),
	IMAGE(3, "Image"),
	DOCUMENT(4, "Document"),
	UNKNOWN(5, "Unknown");
	
	@Getter
	private final int apiVaule;
	@Getter
	private final String type;
	
	private SchoologyConvertedTypeEnum(int apiValue, String type)
	{
		this.apiVaule = apiValue;
		this.type = type;
	}
	
	public static SchoologyConvertedTypeEnum getConvertedType(int apiValue)
	{
		for(SchoologyConvertedTypeEnum type : values()) if(type.apiVaule == apiValue) return type;
		
		return null;
	}
	
}
