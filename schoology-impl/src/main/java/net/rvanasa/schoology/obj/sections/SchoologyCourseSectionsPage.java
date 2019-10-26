package net.rvanasa.schoology.obj.sections;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyPage;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course-section
 * Represents a page of sections for given course
 */
@Getter
public class SchoologyCourseSectionsPage extends SchoologyPage<SchoologyCourseSectionsPage>
{
	
	@SerializedName(value="section")
	SchoologyCourseSection[] sections;
	
}
