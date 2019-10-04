package net.rvanasa.schoology.obj.schools;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * As per API documentation, buildings and schools have the same fields:
 * https://developers.schoology.com/api-documentation/rest-api-v1/building 
 */
@Getter
public abstract class SchoologyInstitution
{
	
	String id;
	String title;
	String address1;
	String address2;
	String city;
	String state;
	String postal_code;
	String country;
	String website;
	String phone;
	String fax;
	String picture_url;
	
	SchoologyLinks links;
	
}
