package net.rvanasa.schoology;

import net.rvanasa.schoology.obj.courses.SchoologyCourse;
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
	
}
