package net.rvanasa.schoology.obj.updates;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyPage;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/updates
 * Represents a page of updates for given course
 */
@Getter
public class SchoologyUpdatesPage extends SchoologyPage<SchoologyUpdatesPage>
{
	
	@SerializedName(value="update")
	SchoologyUpdate[] updates;
	
}
