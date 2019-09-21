package net.rvanasa.schoology;

import net.rvanasa.schoology.realms.courses.SchoologyCourse;
import net.rvanasa.schoology.realms.groups.SchoologyGroup;
import net.rvanasa.schoology.realms.schools.SchoologySchool;
import net.rvanasa.schoology.realms.schools.buildings.SchoologyBuilding;
import net.rvanasa.schoology.realms.sections.SchoologyCourseSection;
import net.rvanasa.schoology.realms.users.SchoologyUser;

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

}
