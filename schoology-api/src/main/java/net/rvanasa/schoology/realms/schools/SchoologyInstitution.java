package net.rvanasa.schoology.realms.schools;

import lombok.Getter;

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
	
}
