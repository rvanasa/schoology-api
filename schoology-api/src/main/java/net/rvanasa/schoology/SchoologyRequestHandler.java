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
	
	public SchoologyUpdate[] getRecentUpdates();
	
	public SchoologyUpdateComment[] getUpdateComments(SchoologyUpdate update);
	
	public SchoologyEvent[] getEvents(String endpoint); 
			
	public SchoologyEvent[] getDistrictEvents(String district_id);
	
	public SchoologyEvent[] getSchoolEvent(String school_id);
	
	public SchoologyEvent[] getUserEvents(String user_id);
	
	public SchoologyEvent[] getSectionEvents(String section_id);
	
	public SchoologyEvent[] getGroupEvents(String group_id);
	
}
