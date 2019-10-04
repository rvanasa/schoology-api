package net.rvanasa.schoology.obj.attachments;

import lombok.Getter;

/*
 * https://developers.schoology.com/api/retrieving-attachments#File_Object
 */
public enum SchoologyConvertedStatusEnum
{
	
	COMPLETED(1, "The file has been converted and is available"),
	PENDING(2, "The file is pending conversion"),
	FAILED(3, "File conversion has failed"),
	INACTIVE(4, "Any sort of conversion attempts are inactive");
	
	@Getter
	private final int apiVaule;
	@Getter
	private final String meaning;
	
	private SchoologyConvertedStatusEnum(int apiValue, String meaning)
	{
		this.apiVaule = apiValue;
		this.meaning = meaning;
	}
	
	public static SchoologyConvertedStatusEnum getConvertedStatus(int apiValue)
	{
		for(SchoologyConvertedStatusEnum status : values()) if(status.apiVaule == apiValue) return status;
		
		return null;
	}
	
}
