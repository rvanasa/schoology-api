package net.rvanasa.schoology;

import net.rvanasa.schoology.obj.albums.SchoologyMediaAlbumContent;
import net.rvanasa.schoology.obj.albums.SchoologyMediaAlbums;
import net.rvanasa.schoology.obj.albums.comments.SchoologyMediaAlbumComment;
import net.rvanasa.schoology.obj.blog.SchoologyBlogPost;
import net.rvanasa.schoology.obj.blog.SchoologyBlogPostComment;
import net.rvanasa.schoology.obj.courses.SchoologyCourse;
import net.rvanasa.schoology.obj.courses.SchoologyCoursesPage;
import net.rvanasa.schoology.obj.discussions.SchoologyDiscussionRepliesPage;
import net.rvanasa.schoology.obj.discussions.SchoologyDiscussionsPage;
import net.rvanasa.schoology.obj.enrollment.SchoologyEnrollmentsPage;
import net.rvanasa.schoology.obj.events.SchoologyEventsPage;
import net.rvanasa.schoology.obj.groups.SchoologyGroup;
import net.rvanasa.schoology.obj.groups.SchoologyGroupsPage;
import net.rvanasa.schoology.obj.schools.SchoologySchool;
import net.rvanasa.schoology.obj.schools.buildings.SchoologyBuilding;
import net.rvanasa.schoology.obj.sections.SchoologyCourseSection;
import net.rvanasa.schoology.obj.sections.SchoologyCourseSectionsPage;
import net.rvanasa.schoology.obj.updates.SchoologyUpdate;
import net.rvanasa.schoology.obj.updates.comments.SchoologyUpdateComment;
import net.rvanasa.schoology.obj.users.SchoologyUser;
import net.rvanasa.schoology.obj.users.SchoologyUsersPage;

public interface ISchoologyRequestHandler
{
	public ISchoologyResponse get(String resource);
	
	public ISchoologyResponse multiget(String... resources);
	
	public ISchoologyResponse post(String resource, String body);
	
	public ISchoologyResponse put(String resource, String body);
	
	public ISchoologyResponse delete(String resource);
	
	public ISchoologyResponse options(String resource);
	
	/*
	 * Java object implementations
	 */
	public SchoologyUsersPage getUsersPage();
	
	public SchoologyUser getUser(String uid);
		
	public SchoologyGroupsPage getGroupsPage();
			
	public SchoologyGroup getGroup(String group_id);
	
	public SchoologyCoursesPage getCoursesPage();
	
	public SchoologyCourse getCourse(String course_id);
	
	public SchoologyCourseSectionsPage getCourseSectionsPage(String course_id);
	
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
	
	public SchoologyEventsPage getEventsPage(String realm); 
			
	default public SchoologyEventsPage getDistrictEvents(String district_id)
	{
		return getEventsPage("districts/" + district_id);
	}
	
	default public SchoologyEventsPage getSchoolEvent(String school_id)
	{
		return getEventsPage("schools/" + school_id);
	}
	
	default public SchoologyEventsPage getUserEvents(String user_id)
	{
		return getEventsPage("users/" + user_id);
	}
	
	default public SchoologyEventsPage getSectionEvents(String section_id)
	{
		return getEventsPage("sections/" + section_id);
	}
	
	default public SchoologyEventsPage getGroupEvents(String group_id)
	{
		return getEventsPage("groups/" + group_id);
	}
	
	public SchoologyEnrollmentsPage getEnrollmentsPage(String realm);
	
	default public SchoologyEnrollmentsPage getSectionEnrollmentsPage(String section_id)
	{
		return getEnrollmentsPage("sections/" + section_id);
	}
	
	default public SchoologyEnrollmentsPage getGroupEnrollmentsPage(String group_id)
	{
		return getEnrollmentsPage("groups/" + group_id);
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
	
	public SchoologyDiscussionsPage getDiscussionsPage(String realm);
	
	default public SchoologyDiscussionsPage getDistrictDiscussionPage(String district_id)
	{
		return getDiscussionsPage("districts/" + district_id);
	}
	
	default public SchoologyDiscussionsPage getSchoolDiscussionPage(String school_id)
	{
		return getDiscussionsPage("schools/" + school_id);
	}
	
	default public SchoologyDiscussionsPage getSectionDiscussionPage(String section_id)
	{
		return getDiscussionsPage("sections/" + section_id);
	}
	
	default public SchoologyDiscussionsPage getGroupDiscussionPage(String group_id)
	{
		return getDiscussionsPage("groups/" + group_id);
	}
	
	public SchoologyDiscussionRepliesPage getDiscussionRepliesPage(String realm, String discussion_id);
	
	default public SchoologyDiscussionRepliesPage getDistrictDiscussionRepliesPage(String district_id, String discussion_id)
	{
		return getDiscussionRepliesPage("districts/" + district_id, discussion_id);
	}
	
	default public SchoologyDiscussionRepliesPage getSchoolDiscussionRepliesPage(String school_id, String discussion_id)
	{
		return getDiscussionRepliesPage("schools/" + school_id, discussion_id);
	}
	
	default public SchoologyDiscussionRepliesPage getSectionDiscussionRepliesPage(String section_id, String discussion_id)
	{
		return getDiscussionRepliesPage("sections/" + section_id, discussion_id);
	}
	
	default public SchoologyDiscussionRepliesPage getGroupDiscussionRepliesPage(String group_id, String discussion_id)
	{
		return getDiscussionRepliesPage("groups/" + group_id, discussion_id);
	}
	
	public SchoologyMediaAlbums getMediaAlbums(String realm);
	
	default public SchoologyMediaAlbums getSectionMediaAlbums(String section_id)
	{
		return getMediaAlbums("sections/" + section_id);
	}
	
	default public SchoologyMediaAlbums getGroupMediaAlbums(String group_id)
	{
		return getMediaAlbums("groups/" + group_id);
	}
	
	public SchoologyMediaAlbumContent[] getMediaAlbumContent(String realm, String album_id);
	
	default public SchoologyMediaAlbumContent[] getSectionMediaAlbumContent(String section_id, String album_id)
	{
		return getMediaAlbumContent("sections/" + section_id, album_id);
	}
	
	default public SchoologyMediaAlbumContent[] getGroupMediaAlbumContent(String group_id, String album_id)
	{
		return getMediaAlbumContent("groups/" + group_id, album_id);
	}
	
	public SchoologyMediaAlbumComment[] getMediaAlbumContentComment(String realm, String album_id, String content_id);
	
	default public SchoologyMediaAlbumComment[] getSectionMediaAlbumContentComment(String section_id, String album_id, String content_id)
	{
		return getMediaAlbumContentComment("sections/" + section_id, album_id, content_id);
	}
	
	default public SchoologyMediaAlbumComment[] getGroupMediaAlbumContentComment(String group_id, String album_id, String content_id)
	{
		return getMediaAlbumContentComment("groups/" + group_id, album_id, content_id);
	}
	
}
