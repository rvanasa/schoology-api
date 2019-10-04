package net.rvanasa.schoology.obj.courses;

import lombok.Getter;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course#Grade-Range
 */
public enum SchoologyGradeRangeEnum
{
	
	NONE(0, "No grade level/remove grade level"),
	PRE_K(1, "Pre-K"),
	K(2, "K"),
	GRADE_1(3, "1"),
	GRADE_2(4, "2"),
	GRADE_3(5, "3"),
	GRADE_4(6, "4"),
	GRADE_5(7, "5"),
	GRADE_6(8, "6"),
	GRADE_7(9, "7"),
	GRADE_8(10, "8"),
	GRADE_9(11, "9"),
	GRADE_10(12, "10"),
	GRADE_11(13, "11"),
	GRADE_12(14, "12"),
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
