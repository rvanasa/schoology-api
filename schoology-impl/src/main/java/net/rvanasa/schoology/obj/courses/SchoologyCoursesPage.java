package net.rvanasa.schoology.obj.courses;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyPage;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/course
 * Represents a page of courses
 */
@Getter
public class SchoologyCoursesPage extends SchoologyPage<SchoologyCoursesPage>
{
	
	SchoologyCourse[] course;
	
}
