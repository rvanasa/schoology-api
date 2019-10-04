package net.rvanasa.schoology.obj.enrollment;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyPage;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/enrollment
 * Represents a page of enrollments
 */
@Getter
public class SchoologyEnrollmentsPage extends SchoologyPage
{
	
	SchoologyEnrollment[] enrollment;
	
}
