package net.rvanasa.schoology.obj.discussions;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import net.rvanasa.schoology.obj.SchoologyPage;

/*
 * https://developers.schoology.com/api-documentation/rest-api-v1/discussion-thread
 * Represents a page of discussions
 */
@Getter
public class SchoologyDiscussionsPage extends SchoologyPage<SchoologyDiscussionsPage>
{
	
	@SerializedName(value="discussion")
	SchoologyDiscussionThread[] discussions;
	
}
