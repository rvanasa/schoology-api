package net.rvanasa.schoology.obj.attachments;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api/retrieving-attachments#File_Object
 */
public enum SchoologyConvertedStatusEnum
{
	
	@SerializedName(value="1")
	COMPLETED(1, "The file has been converted and is available"),
	@SerializedName(value="2")
	PENDING(2, "The file is pending conversion"),
	@SerializedName(value="3")
	FAILED(3, "File conversion has failed"),
	@SerializedName(value="4")
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
