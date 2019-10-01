package net.rvanasa.schoology.obj;

import lombok.Getter;

/*
 * Represents a page of data with size of entries and link to self and next page
 */
@Getter
public abstract class SchoologyPage
{
	
	int total;
	
	SchoologyLinks links;
	
}