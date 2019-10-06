package net.rvanasa.schoology.obj.courses;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course#Grade-Range
 */
public enum SchoologyGradeRangeEnum
{
	
	@SerializedName(value="0")
	NONE(0, "No grade level/remove grade level"),
	@SerializedName(value="1")
	PRE_K(1, "Pre-K"),
	@SerializedName(value="2")
	K(2, "K"),
	@SerializedName(value="3")
	GRADE_1(3, "1"),
	@SerializedName(value="4")
	GRADE_2(4, "2"),
	@SerializedName(value="5")
	GRADE_3(5, "3"),
	@SerializedName(value="6")
	GRADE_4(6, "4"),
	@SerializedName(value="7")
	GRADE_5(7, "5"),
	@SerializedName(value="8")
	GRADE_6(8, "6"),
	@SerializedName(value="9")
	GRADE_7(9, "7"),
	@SerializedName(value="10")
	GRADE_8(10, "8"),
	@SerializedName(value="11")
	GRADE_9(11, "9"),
	@SerializedName(value="12")
	GRADE_10(12, "10"),
	@SerializedName(value="13")
	GRADE_11(13, "11"),
	@SerializedName(value="14")
	GRADE_12(14, "12"),
	@SerializedName(value="15")
	HIGHER_ED(15, "Higher-Ed");
	
	@Getter
	private final int apiVaule;
	@Getter
	private final String gradeLevel;
	
	private SchoologyGradeRangeEnum(int apiValue, String subjectArea)
	{
		this.apiVaule = apiValue;
		this.gradeLevel = subjectArea;
	}
	
	public static SchoologyGradeRangeEnum getGradeLevel(int apiValue)
	{
		for(SchoologyGradeRangeEnum gradeRange : values()) if(gradeRange.getApiVaule() == apiValue) return gradeRange;
		
		return null;
	}
	
}
