package net.rvanasa.schoology.obj.users;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyPage;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/user
 * Represents a page of users provided by /users endpoint.
 * Provides link to next as well as size of users listed on current page.
 */
@Getter
public class SchoologyUsersPage extends SchoologyPage<SchoologyUsersPage>
{
	
	@SerializedName(value="user")
	SchoologyUser[] users;
	
}
