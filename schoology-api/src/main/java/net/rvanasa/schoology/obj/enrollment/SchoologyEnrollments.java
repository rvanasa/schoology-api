package net.rvanasa.schoology.obj.enrollment;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/enrollment
 */
@Getter
public class SchoologyEnrollments
{
	
	SchoologyEnrollment[] enrollment;
	int total;
	
	SchoologyLinks links;
	
}
