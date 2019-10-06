package net.rvanasa.schoology.obj.schools;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyLinks;

/*
 * As per API documentation, buildings and schools have the same fields:
 * https://developers.schoology.com/api-documentation/rest-api-v1/building 
 */
@Getter
public abstract class SchoologyInstitution
{
	
	@SerializedName(value="id")
	String ID;
	String title;
	String address1;
	String address2;
	String city;
	String state;
	@SerializedName(value="postal_code")
	String postalCode;
	String country;
	String website;
	String phone;
	String fax;
	@SerializedName(value="picture_url")
	String pictureURL;
	
	SchoologyLinks links;
	
}
