package net.rvanasa.schoology;

import net.rvanasa.schoology.impl.SchoologyRealm;
import net.rvanasa.schoology.impl.SchoologyResponse;
import net.rvanasa.schoology.obj.albums.SchoologyMediaAlbumContent;
import net.rvanasa.schoology.obj.albums.SchoologyMediaAlbumsPage;
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
import net.rvanasa.schoology.obj.messages.SchoologyMessageStatus;
import net.rvanasa.schoology.obj.messages.SchoologyPrivateMessage;
import net.rvanasa.schoology.obj.messages.SchoologyPrivateMessagesPage;
import net.rvanasa.schoology.obj.schools.SchoologySchool;
import net.rvanasa.schoology.obj.schools.buildings.SchoologyBuilding;
import net.rvanasa.schoology.obj.sections.SchoologyCourseSection;
import net.rvanasa.schoology.obj.sections.SchoologyCourseSectionsPage;
import net.rvanasa.schoology.obj.updates.SchoologyUpdate;
import net.rvanasa.schoology.obj.updates.SchoologyUpdatesPage;
import net.rvanasa.schoology.obj.updates.comments.SchoologyUpdateComment;
import net.rvanasa.schoology.obj.users.SchoologyUser;
import net.rvanasa.schoology.obj.users.SchoologyUsersPage;

public interface ISchoologyRequestHandler
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
	public SchoologyUsersPage getUsersPage();
	
	public SchoologyUser getUser(String uid);
		
	public SchoologyGroupsPage getGroupsPage();
			
	public SchoologyGroup getGroup(String group_id);
	
	public SchoologyCoursesPage getCoursesPage();
	
	public SchoologyCourse getCourse(String course_id);
	
	public SchoologyCourseSectionsPage getSectionsPage(String realm);
	
	default public SchoologyCourseSectionsPage getCourseSectionsPage(String course_id)
	{
		return getSectionsPage(SchoologyRealm.COURSE + course_id);
	}
	
	default public SchoologyCourseSectionsPage getUserSectionsPage(String user_id)
	{
		return getSectionsPage(SchoologyRealm.USER + user_id);
	}
	
	public SchoologyCourseSection getCourseSection(String section_id);
	
	public SchoologySchool[] getSchools();
	
	public SchoologySchool getSchool(String school_id);
	
	public SchoologyBuilding[] getBuildings(String school_id);
	
	public SchoologyBuilding getBuilding(String building_id);
	
	public SchoologyUpdatesPage getUpdates(String realm);
	
	default public SchoologyUpdatesPage getRecentUpdates()
	{
		return getUpdates("recent");
	}
	
	default public SchoologyUpdatesPage getUserUpdates(String user_id)
	{
		return getUpdates(SchoologyRealm.USER + user_id);
	}
	
	default public SchoologyUpdatesPage getSectionUpdates(String section_id)
	{
		return getUpdates(SchoologyRealm.COURSE_SECTION + section_id);
	}
	
	default public SchoologyUpdatesPage getGroupUpdates(String group_id)
	{
		return getUpdates(SchoologyRealm.GROUP + group_id);
	}
	
	public SchoologyUpdateComment[] getUpdateComments(SchoologyUpdate update);
	
	public SchoologyEventsPage getEventsPage(String realm); 
			
	default public SchoologyEventsPage getDistrictEvents(String district_id)
	{
		return getEventsPage("districts/" + district_id);
	}
	
	default public SchoologyEventsPage getSchoolEvent(String school_id)
	{
		return getEventsPage(SchoologyRealm.SCHOOL + school_id);
	}
	
	default public SchoologyEventsPage getUserEvents(String user_id)
	{
		return getEventsPage(SchoologyRealm.USER + user_id);
	}
	
	default public SchoologyEventsPage getSectionEvents(String section_id)
	{
		return getEventsPage(SchoologyRealm.COURSE_SECTION + section_id);
	}
	
	default public SchoologyEventsPage getGroupEvents(String group_id)
	{
		return getEventsPage(SchoologyRealm.GROUP + group_id);
	}
	
	public SchoologyEnrollmentsPage getEnrollmentsPage(String realm);
	
	default public SchoologyEnrollmentsPage getSectionEnrollmentsPage(String section_id)
	{
		return getEnrollmentsPage(SchoologyRealm.COURSE_SECTION + section_id);
	}
	
	default public SchoologyEnrollmentsPage getGroupEnrollmentsPage(String group_id)
	{
		return getEnrollmentsPage(SchoologyRealm.GROUP + group_id);
	}
	
	public SchoologyBlogPost[] getBlogPosts(String realm);
	
	default public SchoologyBlogPost[] getDistrictBlogPosts(String district_id)
	{
		return getBlogPosts("districts/" + district_id);
	}
	
	default public SchoologyBlogPost[] getSchoolBlogPosts(String school_id)
	{
		return getBlogPosts(SchoologyRealm.SCHOOL + school_id);
	}
	
	default public SchoologyBlogPost[] getUserBlogPosts(String user_id)
	{
		return getBlogPosts(SchoologyRealm.USER + user_id);
	}
	
	default public SchoologyBlogPost[] getSectionBlogPosts(String section_id)
	{
		return getBlogPosts(SchoologyRealm.COURSE_SECTION + section_id);
	}
	
	default public SchoologyBlogPost[] getGroupBlogPosts(String group_id)
	{
		return getBlogPosts(SchoologyRealm.GROUP + group_id);
	}
	
	public SchoologyBlogPostComment[] getBlogPostComments(String realm, String post_id);
	
	default public SchoologyBlogPostComment[] getDistrictBlogPostComments(String district_id, String post_id)
	{
		return getBlogPostComments("districts/" + district_id, post_id);
	}
	
	default public SchoologyBlogPostComment[] getSchoolBlogPostComments(String school_id, String post_id)
	{
		return getBlogPostComments(SchoologyRealm.SCHOOL + school_id, post_id);
	}
	
	default public SchoologyBlogPostComment[] getUserBlogPostComments(String user_id, String post_id)
	{
		return getBlogPostComments(SchoologyRealm.USER + user_id, post_id);
	}
	
	default public SchoologyBlogPostComment[] getSectionBlogPostComments(String section_id, String post_id)
	{
		return getBlogPostComments(SchoologyRealm.COURSE_SECTION + section_id, post_id);
	}
	
	default public SchoologyBlogPostComment[] getGroupBlogPostComments(String group_id, String post_id)
	{
		return getBlogPostComments(SchoologyRealm.GROUP + group_id, post_id);
	}
	
	public SchoologyDiscussionsPage getDiscussionsPage(String realm);
	
	default public SchoologyDiscussionsPage getDistrictDiscussionPage(String district_id)
	{
		return getDiscussionsPage("districts/" + district_id);
	}
	
	default public SchoologyDiscussionsPage getSchoolDiscussionPage(String school_id)
	{
		return getDiscussionsPage(SchoologyRealm.SCHOOL + school_id);
	}
	
	default public SchoologyDiscussionsPage getSectionDiscussionPage(String section_id)
	{
		return getDiscussionsPage(SchoologyRealm.COURSE_SECTION + section_id);
	}
	
	default public SchoologyDiscussionsPage getGroupDiscussionPage(String group_id)
	{
		return getDiscussionsPage(SchoologyRealm.GROUP + group_id);
	}
	
	public SchoologyDiscussionRepliesPage getDiscussionRepliesPage(String realm, String discussion_id);
	
	default public SchoologyDiscussionRepliesPage getDistrictDiscussionRepliesPage(String district_id, String discussion_id)
	{
		return getDiscussionRepliesPage("districts/" + district_id, discussion_id);
	}
	
	default public SchoologyDiscussionRepliesPage getSchoolDiscussionRepliesPage(String school_id, String discussion_id)
	{
		return getDiscussionRepliesPage(SchoologyRealm.SCHOOL + school_id, discussion_id);
	}
	
	default public SchoologyDiscussionRepliesPage getSectionDiscussionRepliesPage(String section_id, String discussion_id)
	{
		return getDiscussionRepliesPage(SchoologyRealm.COURSE_SECTION + section_id, discussion_id);
	}
	
	default public SchoologyDiscussionRepliesPage getGroupDiscussionRepliesPage(String group_id, String discussion_id)
	{
		return getDiscussionRepliesPage(SchoologyRealm.GROUP + group_id, discussion_id);
	}
	
	public SchoologyMediaAlbumsPage getMediaAlbumsPage(String realm);
	
	default public SchoologyMediaAlbumsPage getSectionMediaAlbums(String section_id)
	{
		return getMediaAlbumsPage(SchoologyRealm.COURSE_SECTION + section_id);
	}
	
	default public SchoologyMediaAlbumsPage getGroupMediaAlbums(String group_id)
	{
		return getMediaAlbumsPage(SchoologyRealm.GROUP + group_id);
	}
	
	public SchoologyMediaAlbumContent[] getMediaAlbumContent(String realm, String album_id);
	
	default public SchoologyMediaAlbumContent[] getSectionMediaAlbumContent(String section_id, String album_id)
	{
		return getMediaAlbumContent(SchoologyRealm.COURSE_SECTION + section_id, album_id);
	}
	
	default public SchoologyMediaAlbumContent[] getGroupMediaAlbumContent(String group_id, String album_id)
	{
		return getMediaAlbumContent(SchoologyRealm.GROUP + group_id, album_id);
	}
	
	public SchoologyMediaAlbumComment[] getMediaAlbumContentComment(String realm, String album_id, String content_id);
	
	default public SchoologyMediaAlbumComment[] getSectionMediaAlbumContentComment(String section_id, String album_id, String content_id)
	{
		return getMediaAlbumContentComment(SchoologyRealm.COURSE_SECTION + section_id, album_id, content_id);
	}
	
	default public SchoologyMediaAlbumComment[] getGroupMediaAlbumContentComment(String group_id, String album_id, String content_id)
	{
		return getMediaAlbumContentComment(SchoologyRealm.GROUP + group_id, album_id, content_id);
	}
	
	public SchoologyPrivateMessage getPrivateMessage(String folder, String message_id);
	
	default public SchoologyPrivateMessage getPrivateMessageInbox(String message_id)
	{
		return getPrivateMessage("inbox", message_id);
	}
	
	default public SchoologyPrivateMessage getPrivateMessageSent(String message_id)
	{
		return getPrivateMessage("sent", message_id);
	}
	
	public SchoologyPrivateMessagesPage getPrivateMessagesPage(String folder);
	
	default public SchoologyPrivateMessagesPage getPrivateMessagesInboxPage()
	{
		return getPrivateMessagesPage("inbox");
	}
	
	default public SchoologyPrivateMessagesPage getPrivateMessagesSentPage()
	{
		return getPrivateMessagesPage("sent");
	}
	
}
