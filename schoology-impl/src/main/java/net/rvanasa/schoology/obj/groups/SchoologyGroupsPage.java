package net.rvanasa.schoology.obj.groups;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyPage;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/group
 * Represents a page of groups 
 */
@Getter
public class SchoologyGroupsPage extends SchoologyPage<SchoologyGroupsPage>
{
	
	@SerializedName(value="group")
	SchoologyGroup[] groups;
	
}
