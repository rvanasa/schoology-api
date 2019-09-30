package net.rvanasa.schoology;

import net.rvanasa.schoology.obj.blog.SchoologyBlogPost;
import net.rvanasa.schoology.obj.blog.SchoologyBlogPostComment;
import net.rvanasa.schoology.obj.courses.SchoologyCourse;
import net.rvanasa.schoology.obj.discussions.SchoologyDiscussionReply;
import net.rvanasa.schoology.obj.discussions.SchoologyDiscussions;
import net.rvanasa.schoology.obj.enrollment.SchoologyEnrollments;
import net.rvanasa.schoology.obj.events.SchoologyEvent;
import net.rvanasa.schoology.obj.groups.SchoologyGroup;
import net.rvanasa.schoology.obj.schools.SchoologySchool;
import net.rvanasa.schoology.obj.schools.buildings.SchoologyBuilding;
import net.rvanasa.schoology.obj.sections.SchoologyCourseSection;
import net.rvanasa.schoology.obj.updates.SchoologyUpdate;
import net.rvanasa.schoology.obj.updates.comments.SchoologyUpdateComment;
import net.rvanasa.schoology.obj.users.SchoologyUser;

public interface SchoologyRequestHandler
{
	public SchoologyResponse get(String resource);
	
	public SchoologyResponse multiget(String... resources);
	
	public SchoologyResponse post(String resource, String body);
	
	public SchoologyResponse put(String resource, String body);
	
	public SchoologyResponse delete(String resource);
	
	public SchoologyResponse options(String resource);
	
	/*
	 * Java object implementations
	 */
	public SchoologyUser[] getUsers();
	
	public SchoologyUser getUser(String uid);
		
	public SchoologyGroup[] getGroups();
			
	public SchoologyGroup getGroup(String group_id);
	
	public SchoologyCourse[] getCourses();
	
	public SchoologyCourse getCourse(String course_id);
	
	public SchoologyCourseSection[] getCourseSections(String course_id);
	
	public SchoologyCourseSection getCourseSection(String section_id);
	
	public SchoologySchool[] getSchools();
	
	public SchoologySchool getSchool(String school_id);
	
	public SchoologyBuilding[] getBuildings(String school_id);
	
	public SchoologyUpdate[] getUpdates(String realm);
	
	default public SchoologyUpdate[] getRecentUpdates()
	{
		return getUpdates("recent");
	}
	
	default public SchoologyUpdate[] getUserUpdates(String user_id)
	{
		return getUpdates("users/" + user_id);
	}
	
	default public SchoologyUpdate[] getSectionUpdates(String section_id)
	{
		return getUpdates("sections/" + section_id);
	}
	
	default public SchoologyUpdate[] getGroupUpdates(String group_id)
	{
		return getUpdates("groups/" + group_id);
	}
	
	public SchoologyUpdateComment[] getUpdateComments(SchoologyUpdate update);
	
	public SchoologyEvent[] getEvents(String realm); 
			
	default public SchoologyEvent[] getDistrictEvents(String district_id)
	{
		return getEvents("districts/" + district_id);
	}
	
	default public SchoologyEvent[] getSchoolEvent(String school_id)
	{
		return getEvents("schools/" + school_id);
	}
	
	default public SchoologyEvent[] getUserEvents(String user_id)
	{
		return getEvents("users/" + user_id);
	}
	
	default public SchoologyEvent[] getSectionEvents(String section_id)
	{
		return getEvents("sections/" + section_id);
	}
	
	default public SchoologyEvent[] getGroupEvents(String group_id)
	{
		return getEvents("groups/" + group_id);
	}
	
	public SchoologyEnrollments getEnrollments(String realm);
	
	default public SchoologyEnrollments getSectionEnrollments(String section_id)
	{
		return getEnrollments("sections/" + section_id);
	}
	
	default public SchoologyEnrollments getGroupEnrollments(String group_id)
	{
		return getEnrollments("groups/" + group_id);
	}
	
	public SchoologyBlogPost[] getBlogPosts(String realm);
	
	default public SchoologyBlogPost[] getDistrictBlogPosts(String district_id)
	{
		return getBlogPosts("districts/" + district_id);
	}
	
	default public SchoologyBlogPost[] getSchoolBlogPosts(String school_id)
	{
		return getBlogPosts("schools/" + school_id);
	}
	
	default public SchoologyBlogPost[] getUserBlogPosts(String user_id)
	{
		return getBlogPosts("users/" + user_id);
	}
	
	default public SchoologyBlogPost[] getSectionBlogPosts(String section_id)
	{
		return getBlogPosts("sections/" + section_id);
	}
	
	default public SchoologyBlogPost[] getGroupBlogPosts(String group_id)
	{
		return getBlogPosts("groups/" + group_id);
	}
	
	public SchoologyBlogPostComment[] getBlogPostComments(String realm, String post_id);
	
	default public SchoologyBlogPostComment[] getDistrictBlogPostComments(String district_id, String post_id)
	{
		return getBlogPostComments("districts/" + district_id, post_id);
	}
	
	default public SchoologyBlogPostComment[] getSchoolBlogPostComments(String school_id, String post_id)
	{
		return getBlogPostComments("schools/" + school_id, post_id);
	}
	
	default public SchoologyBlogPostComment[] getUserBlogPostComments(String user_id, String post_id)
	{
		return getBlogPostComments("ysers/" + user_id, post_id);
	}
	
	default public SchoologyBlogPostComment[] getSectionBlogPostComments(String section_id, String post_id)
	{
		return getBlogPostComments("sections/" + section_id, post_id);
	}
	
	default public SchoologyBlogPostComment[] getGroupBlogPostComments(String group_id, String post_id)
	{
		return getBlogPostComments("groups/" + group_id, post_id);
	}
	
	public SchoologyDiscussions getDiscussions(String realm);
	
	default public SchoologyDiscussions getDistrictDiscussion(String district_id)
	{
		return getDiscussions("districts/" + district_id);
	}
	
	default public SchoologyDiscussions getSchoolDiscussion(String school_id)
	{
		return getDiscussions("schools/" + school_id);
	}
	
	default public SchoologyDiscussions getSectionDiscussion(String section_id)
	{
		return getDiscussions("sections/" + section_id);
	}
	
	default public SchoologyDiscussions getGroupDiscussion(String group_id)
	{
		return getDiscussions("groups/" + group_id);
	}
	
	public SchoologyDiscussionReply[] getDiscussionReplies(String realm, String discussion_id);
	
	default public SchoologyDiscussionReply[] getDistrictDiscussionReplies(String district_id, String discussion_id)
	{
		return getDiscussionReplies("districts/" + district_id, discussion_id);
	}
	
	default public SchoologyDiscussionReply[] getSchoolDiscussionReplies(String school_id, String discussion_id)
	{
		return getDiscussionReplies("schools/" + school_id, discussion_id);
	}
	
	default public SchoologyDiscussionReply[] getSectionDiscussionReplies(String section_id, String discussion_id)
	{
		return getDiscussionReplies("sections/" + section_id, discussion_id);
	}
	
	default public SchoologyDiscussionReply[] getGroupDiscussionReplies(String group_id, String discussion_id)
	{
		return getDiscussionReplies("groups/" + group_id, discussion_id);
	}
}
