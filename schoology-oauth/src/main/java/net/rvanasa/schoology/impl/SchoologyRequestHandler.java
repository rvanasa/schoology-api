package net.rvanasa.schoology.impl;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Getter;
import lombok.Setter;
import net.rvanasa.schoology.ISchoologyRequestHandler;
import net.rvanasa.schoology.adapters.BooleanAdapter;
import net.rvanasa.schoology.adapters.UnixTimestampAdapter;
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
import net.rvanasa.schoology.obj.updates.SchoologyUpdatesPage;
import net.rvanasa.schoology.obj.updates.comments.SchoologyUpdateComment;
import net.rvanasa.schoology.obj.users.SchoologyUser;
import net.rvanasa.schoology.obj.users.SchoologyUsersPage;

public class SchoologyRequestHandler implements ISchoologyRequestHandler
{
	public static OAuthService createService(SchoologyResourceLocator locator, String key, String secret)
	{
		return new ServiceBuilder()
				.provider(new OAuthSchoologyApi(locator))
				.apiKey(key)
				.apiSecret(secret)
				.signatureType(SignatureType.Header)
				.build();
	}
	
	@Getter
	private final SchoologyResourceLocator resourceLocator;
	
	@Getter
	private final OAuthService OAuthService;
	
	@Getter
	public Gson gson;
	
	@Getter
	@Setter
	private SchoologyContentTypeEnum contentType = SchoologyContentTypeEnum.JSON;
	
	@Getter
	@Setter
	private Token accessToken;
	
	public SchoologyRequestHandler(SchoologyResourceLocator locator, String key, String secret)
	{
		this(locator, createService(locator, key, secret));
	}
	
	public SchoologyRequestHandler(String domain, String key, String secret)
	{
		this(new SchoologyResourceLocator(domain), key, secret);
	}
	
	public SchoologyRequestHandler(SchoologyResourceLocator locator, OAuthService service)
	{
		this.resourceLocator = locator;
		this.OAuthService = service;
		
		gson = new GsonBuilder()
		.registerTypeAdapter(boolean.class, new BooleanAdapter())
		.registerTypeAdapter(Date.class, new UnixTimestampAdapter())
		.create();
	}
	
	public OAuthRequest prepareRequest(Verb verb, String resource)
	{	
		String URL = resource;
		String query = null;
		
		final int qIndex = URL.lastIndexOf('?');
		
		if(qIndex != -1)
		{
			query = URL.substring(qIndex + 1);
			URL = URL.substring(0, qIndex);
		}
		
		OAuthRequest request = new OAuthRequest(verb, getResourceLocator().getRequestUrl(URL));
		
		if(query != null) for(Entry<String, String> e : splitQuery(query).entrySet()) request.addQuerystringParameter(e.getKey(), e.getValue());
		
		getOAuthService().signRequest(getAccessToken() != null ? getAccessToken() : Token.empty(), request);
		request.addHeader("Accept", getContentType().getID());
		request.addHeader("Content-Type", getContentType().getID());
		return request;
	}
	
	public SchoologyResponse prepareResponse(Response response)
	{
		return new SchoologyResponse(
				SchoologyResponseStatusEnum.getStatus(response.getCode()),
				new SchoologyResponseBody(getContentType(), response.getBody()),
				new SchoologyResponseHeaders(response.getHeaders()));
	}
	
	/*
	 * Modified method of separating query parameters provided by https://stackoverflow.com/a/13592567
	 */
	public Map<String, String> splitQuery(String query)
	{
		return Arrays.stream(query.split("&"))
	            .map(this::splitQueryParameter).collect(Collectors.toMap(SimpleImmutableEntry::getKey, SimpleImmutableEntry::getValue));
	}

	private SimpleImmutableEntry<String, String> splitQueryParameter(String it)
	{
	    final int idx = it.indexOf("=");
	    final String key = idx > 0 ? it.substring(0, idx) : it;
	    final String value = idx > 0 && it.length() > idx + 1 ? it.substring(idx + 1) : null;
	    return new SimpleImmutableEntry<>(key, value);
	}
	
	@Override
	public SchoologyResponse get(String resource)
	{
		OAuthRequest request = prepareRequest(Verb.GET, resource);
		Response response = request.send();
		
		return prepareResponse(response);
	}
	
	@Override
	public SchoologyResponse multiget(String... resources)
	{
		String payload = "<?xml version='1.0' encoding='utf-8'?><requests>";
		for(String resource : resources)
		{
			payload += "<request>/v1/" + resource + "</request>";
		}
		payload += "</requests>";
		
		OAuthRequest request = prepareRequest(Verb.POST, "multiget");
		request.addHeader("Content-Type", "text/xml");
		request.addPayload(payload);
		
		Response response = request.send();
		
		return prepareResponse(response);
	}
	
	@Override
	public SchoologyResponse post(String resource, String body)
	{
		OAuthRequest request = prepareRequest(Verb.POST, resource);
		request.addPayload(body);
		
		Response response = request.send();
		
		return prepareResponse(response);
	}
	
	@Override
	public SchoologyResponse put(String resource, String body)
	{
		OAuthRequest request = prepareRequest(Verb.PUT, resource);
		request.addPayload(body);
		
		Response response = request.send();
		
		return prepareResponse(response);
	}
	
	@Override
	public SchoologyResponse delete(String resource)
	{
		OAuthRequest request = prepareRequest(Verb.DELETE, resource);
		
		Response response = request.send();
		
		return prepareResponse(response);
	}
	
	@Override
	public SchoologyResponse options(String resource)
	{
		OAuthRequest request = prepareRequest(Verb.OPTIONS, resource);
		Response response = request.send();
		
		return prepareResponse(response);
	}
	
	/*
	 * Java object implementations
	 */
	//TODO: add query string options
	@Override
	public SchoologyUsersPage getUsersPage()
	{
		SchoologyResponse response = get(SchoologyRealm.USER.toString()).requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyUsersPage.class);
	}
	
	@Override
	public SchoologyUser getUser(String uid)
	{
		SchoologyResponse response = get(SchoologyRealm.USER + uid + "?extended=true").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyUser.class).reference(this);
	}
	
	@Override
	public SchoologyGroupsPage getGroupsPage()
	{
		SchoologyResponse response = get(SchoologyRealm.GROUP.toString()).requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyGroupsPage.class);
	}
			
	@Override
	public SchoologyGroup getGroup(String group_id)
	{
		SchoologyResponse response = get(SchoologyRealm.GROUP + group_id).requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyGroup.class);
	}
	
	@Override
	public SchoologyCoursesPage getCoursesPage()
	{
		SchoologyResponse response = get(SchoologyRealm.COURSE.toString()).requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyCoursesPage.class);
	}
	
	@Override
	public SchoologyCourse getCourse(String course_id)
	{
		SchoologyResponse response = get(SchoologyRealm.COURSE + course_id).requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyCourse.class);
	}
	
	@Override
	public SchoologyCourseSectionsPage getCourseSectionsPage(String course_id)
	{
		SchoologyResponse response = get(SchoologyRealm.COURSE + course_id + "/sections").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyCourseSectionsPage.class);
	}
	
	@Override
	public SchoologyCourseSection getCourseSection(String section_id)
	{
		SchoologyResponse response = get(SchoologyRealm.COURSE_SECTION + section_id).requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyCourseSection.class);
	}
	
	@Override
	public SchoologySchool[] getSchools()
	{
		SchoologyResponse response = get(SchoologyRealm.SCHOOL.toString()).requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("school").asRawData(), SchoologySchool[].class);
	}
	
	@Override
	public SchoologySchool getSchool(String school_id)
	{
		SchoologyResponse response = get(SchoologyRealm.SCHOOL + school_id).requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologySchool.class);
	}
	
	@Override
	public SchoologyBuilding[] getBuildings(String school_id)
	{
		SchoologyResponse response = get(SchoologyRealm.SCHOOL + school_id + "/buildings").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("building").asRawData(), SchoologyBuilding[].class);
	}
	
	@Override
	public SchoologyUpdatesPage getUpdates(String realm)
	{
		if(!realm.equalsIgnoreCase("recent")) realm += "/updates";
		
		SchoologyResponse response = get(realm + "?with_attachments=true").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyUpdatesPage.class).reference(this);
	}
	
	@Override
	public SchoologyUpdateComment[] getUpdateComments(SchoologyUpdate update)
	{
		
		SchoologyRealm realm = update.getRealm();
		
		if(realm == null) return new SchoologyUpdateComment[] {};
		
		String endpoint = "";
		
		switch (realm) {
		case BUILDING:
			endpoint = "schools/" + update.getBuildingID() + "/buildings";
			break;
		case COURSE_SECTION:
			endpoint = SchoologyRealm.COURSE + update.getSectionID();
			break;
		case GROUP:
			endpoint = SchoologyRealm.GROUP + update.getGroupID();
			break;
		default:
			break;
		}
		
		SchoologyResponse response = get(endpoint + "/updates/" + update.getID() + "/comments").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("comment").asRawData(), SchoologyUpdateComment[].class);
	}

	@Override
	public SchoologyEventsPage getEventsPage(String realm)
	{
		SchoologyResponse response = get(realm + "/events").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("event").asRawData(), SchoologyEventsPage.class);
	}

	@Override
	public SchoologyEnrollmentsPage getEnrollmentsPage(String realm)
	{
		SchoologyResponse response = get(realm + "/enrollments").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyEnrollmentsPage.class);
	}

	@Override
	public SchoologyBlogPost[] getBlogPosts(String realm)
	{
		SchoologyResponse response = get(realm + "/posts").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("post").asRawData(), SchoologyBlogPost[].class);
	}

	@Override
	public SchoologyBlogPostComment[] getBlogPostComments(String realm, String post_id) {
		SchoologyResponse response = get(realm + "/posts/" + post_id + "/comments").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("comment").asRawData(), SchoologyBlogPostComment[].class);
	}

	@Override
	public SchoologyDiscussionsPage getDiscussionsPage(String realm)
	{
		SchoologyResponse response = get(realm + "/discussions").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyDiscussionsPage.class);
	}
	
	@Override
	public SchoologyDiscussionRepliesPage getDiscussionRepliesPage(String realm, String discussion_id)
	{
		SchoologyResponse response = get(realm + "/discussions/" + discussion_id + "/comments").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("comment").asRawData(), SchoologyDiscussionRepliesPage.class);
	}

	@Override
	public SchoologyMediaAlbums getMediaAlbums(String realm)
	{
		SchoologyResponse response = get(realm + "/albums").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyMediaAlbums.class);
	}
	
	//TODO: Schoology documentation says =1, but should it be =true?
	@Override
	public SchoologyMediaAlbumContent[] getMediaAlbumContent(String realm, String album_id)
	{
		SchoologyResponse response = get(realm + "/albums/" + album_id + "?withcontent=1").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("album").get("content").asRawData(), SchoologyMediaAlbumContent[].class);
	}

	@Override
	public SchoologyMediaAlbumComment[] getMediaAlbumContentComment(String realm, String album_id, String content_id)
	{
		SchoologyResponse response = get(realm + "/albums/" + album_id + "/content/" + content_id + "/comments").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("comment").asRawData(), SchoologyMediaAlbumComment[].class);
	}

}
