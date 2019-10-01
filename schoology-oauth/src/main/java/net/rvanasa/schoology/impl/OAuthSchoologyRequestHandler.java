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

import net.rvanasa.schoology.SchoologyContentType;
import net.rvanasa.schoology.SchoologyRealmEnum;
import net.rvanasa.schoology.SchoologyRequestHandler;
import net.rvanasa.schoology.SchoologyResponse;
import net.rvanasa.schoology.adapters.SchoologyAttachmentTypeAdapter;
import net.rvanasa.schoology.adapters.SchoologyBooleanAdapter;
import net.rvanasa.schoology.adapters.SchoologyConvertedStatusAdapter;
import net.rvanasa.schoology.adapters.SchoologyConvertedTypeAdapter;
import net.rvanasa.schoology.adapters.SchoologyCourseSubjectAreaAdapter;
import net.rvanasa.schoology.adapters.SchoologyEnrollmentStatusAdapter;
import net.rvanasa.schoology.adapters.SchoologyEventTypeAdapter;
import net.rvanasa.schoology.adapters.SchoologyGenderAdapter;
import net.rvanasa.schoology.adapters.SchoologyGradeRangeAdapter;
import net.rvanasa.schoology.adapters.SchoologyRSVPTypeAdapter;
import net.rvanasa.schoology.adapters.SchoologyRealmEnumAdapter;
import net.rvanasa.schoology.adapters.SchoologyUnixTimestampAdapter;
import net.rvanasa.schoology.obj.albums.SchoologyMediaAlbumContent;
import net.rvanasa.schoology.obj.albums.SchoologyMediaAlbums;
import net.rvanasa.schoology.obj.albums.comments.SchoologyMediaAlbumComment;
import net.rvanasa.schoology.obj.attachments.SchoologyAttachmentTypeEnum;
import net.rvanasa.schoology.obj.attachments.SchoologyConvertedStatusEnum;
import net.rvanasa.schoology.obj.attachments.SchoologyConvertedTypeEnum;
import net.rvanasa.schoology.obj.blog.SchoologyBlogPost;
import net.rvanasa.schoology.obj.blog.SchoologyBlogPostComment;
import net.rvanasa.schoology.obj.courses.SchoologyCourse;
import net.rvanasa.schoology.obj.courses.SchoologyCourseSubjectAreaEnum;
import net.rvanasa.schoology.obj.courses.SchoologyGradeRangeEnum;
import net.rvanasa.schoology.obj.discussions.SchoologyDiscussionReply;
import net.rvanasa.schoology.obj.discussions.SchoologyDiscussions;
import net.rvanasa.schoology.obj.enrollment.SchoologyEnrollmentStatus;
import net.rvanasa.schoology.obj.enrollment.SchoologyEnrollments;
import net.rvanasa.schoology.obj.events.SchoologyEvent;
import net.rvanasa.schoology.obj.events.SchoologyEventType;
import net.rvanasa.schoology.obj.events.SchoologyRSVPType;
import net.rvanasa.schoology.obj.groups.SchoologyGroup;
import net.rvanasa.schoology.obj.schools.SchoologySchool;
import net.rvanasa.schoology.obj.schools.buildings.SchoologyBuilding;
import net.rvanasa.schoology.obj.sections.SchoologyCourseSection;
import net.rvanasa.schoology.obj.updates.SchoologyUpdate;
import net.rvanasa.schoology.obj.updates.comments.SchoologyUpdateComment;
import net.rvanasa.schoology.obj.users.SchoologyGenderEnum;
import net.rvanasa.schoology.obj.users.SchoologyUser;

public class OAuthSchoologyRequestHandler implements SchoologyRequestHandler
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
	
	private final SchoologyResourceLocator resourceLocator;
	
	private final OAuthService service;
	
	private Gson gson;
	
	private SchoologyContentType contentType = SchoologyContentTypeEnum.JSON;
	
	private Token accessToken;
	
	public OAuthSchoologyRequestHandler(SchoologyResourceLocator locator, String key, String secret)
	{
		this(locator, createService(locator, key, secret));
	}
	
	public OAuthSchoologyRequestHandler(String domain, String key, String secret)
	{
		this(new SchoologyResourceLocator(domain), key, secret);
	}
	
	public OAuthSchoologyRequestHandler(SchoologyResourceLocator locator, OAuthService service)
	{
		this.resourceLocator = locator;
		this.service = service;
		
		gson = new GsonBuilder()
		.registerTypeAdapter(boolean.class, new SchoologyBooleanAdapter())
		.registerTypeAdapter(SchoologyCourseSubjectAreaEnum.class, new SchoologyCourseSubjectAreaAdapter())
		.registerTypeAdapter(SchoologyGradeRangeEnum.class, new SchoologyGradeRangeAdapter())
		.registerTypeAdapter(SchoologyGenderEnum.class, new SchoologyGenderAdapter())
		.registerTypeAdapter(Date.class, new SchoologyUnixTimestampAdapter())
		.registerTypeAdapter(SchoologyConvertedTypeEnum.class, new SchoologyConvertedTypeAdapter())
		.registerTypeAdapter(SchoologyConvertedStatusEnum.class, new SchoologyConvertedStatusAdapter())
		.registerTypeAdapter(SchoologyAttachmentTypeEnum.class, new SchoologyAttachmentTypeAdapter())
		.registerTypeAdapter(SchoologyRealmEnum.class, new SchoologyRealmEnumAdapter())
		.registerTypeAdapter(SchoologyEventType.class, new SchoologyEventTypeAdapter())
		.registerTypeAdapter(SchoologyRSVPType.class, new SchoologyRSVPTypeAdapter())
		.registerTypeAdapter(SchoologyEnrollmentStatus.class, new SchoologyEnrollmentStatusAdapter())
		.create();
	}
	
	public SchoologyResourceLocator getResourceLocator()
	{
		return resourceLocator;
	}
	
	public OAuthService getOAuthService()
	{
		return service;
	}
	
	public SchoologyContentType getContentType()
	{
		return contentType;
	}
	
	public void setContentType(SchoologyContentType contentType)
	{
		this.contentType = contentType;
	}
	
	public Token getAccessToken()
	{
		return accessToken;
	}
	
	public void setAccessToken(Token accessToken)
	{
		this.accessToken = accessToken;
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
		return new BasicSchoologyResponse(
				SchoologyResponseStatusEnum.getStatus(response.getCode()),
				new BasicSchoologyResponseBody(getContentType(), response.getBody()),
				new BasicSchoologyResponseHeaders(response.getHeaders()));
	}
	
	/*
	 * Modified method of separating query parameters provided by https://stackoverflow.com/a/13592567
	 */
	private Map<String, String> splitQuery(String query)
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
	//TODO: ?extended=true
	@Override
	public SchoologyUser[] getUsers()
	{
		//TODO:
		return null;
	}
	
	@Override
	public SchoologyUser getUser(String uid)
	{
		SchoologyResponse response = get("users/" + uid + "?extended=true").requireSuccess();
		
		return gson.fromJson(response.getBody().getRawData(), SchoologyUser.class);
	}
	
	@Override
	public SchoologyGroup[] getGroups()
	{
		SchoologyResponse response = get("groups").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("group").asRawData(), SchoologyGroup[].class);
	}
			
	@Override
	public SchoologyGroup getGroup(String group_id)
	{
		SchoologyResponse response = get("groups/" + group_id).requireSuccess();
		
		return gson.fromJson(response.getBody().getRawData(), SchoologyGroup.class);
	}
	
	@Override
	public SchoologyCourse[] getCourses()
	{
		SchoologyResponse response = get("courses").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("course").asRawData(), SchoologyCourse[].class);
	}
	
	@Override
	public SchoologyCourse getCourse(String course_id)
	{
		SchoologyResponse response = get("courses/" + course_id).requireSuccess();
		
		return gson.fromJson(response.getBody().getRawData(), SchoologyCourse.class);
	}
	
	@Override
	public SchoologyCourseSection[] getCourseSections(String course_id)
	{
		//TODO:
		return null;
	}
	
	@Override
	public SchoologyCourseSection getCourseSection(String section_id)
	{
		SchoologyResponse response = get("sections/" + section_id).requireSuccess();
		
		return gson.fromJson(response.getBody().getRawData(), SchoologyCourseSection.class);
	}
	
	@Override
	public SchoologySchool[] getSchools()
	{
		SchoologyResponse response = get("schools").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("school").asRawData(), SchoologySchool[].class);
	}
	
	@Override
	public SchoologySchool getSchool(String school_id)
	{
		SchoologyResponse response = get("schools/" + school_id).requireSuccess();
		
		return gson.fromJson(response.getBody().getRawData(), SchoologySchool.class);
	}
	
	@Override
	public SchoologyBuilding[] getBuildings(String school_id)
	{
		SchoologyResponse response = get("schools/" + school_id + "/buildings").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("building").asRawData(), SchoologyBuilding[].class);
	}
	
	@Override
	public SchoologyUpdate[] getUpdates(String realm)
	{
		if(!realm.equalsIgnoreCase("recent")) realm += "/updates";
		
		SchoologyResponse response = get(realm + "?with_attachments=true").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("update").asRawData(), SchoologyUpdate[].class);
	}
	
	@Override
	public SchoologyUpdateComment[] getUpdateComments(SchoologyUpdate update)
	{
		
		SchoologyRealmEnum realm = update.getRealm();
		
		if(realm == null) return new SchoologyUpdateComment[] {};
		
		String endpoint = "";
		
		switch (realm) {
		case BUILDING:
			endpoint = "schools/" + update.getBuilding_id() + "/buildings";
			break;
		case COURSE_SECTION:
			endpoint = "course/" + update.getSection_id();
			break;
		case GROUP:
			endpoint = "group/" + update.getGroup_id();
			break;
		default:
			break;
		}
		
		SchoologyResponse response = get(endpoint + "/updates/" + update.getId() + "/comments").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("comment").asRawData(), SchoologyUpdateComment[].class);
	}

	@Override
	public SchoologyEvent[] getEvents(String realm)
	{
		SchoologyResponse response = get(realm + "/events").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("event").asRawData(), SchoologyEvent[].class);
	}

	@Override
	public SchoologyEnrollments getEnrollments(String realm)
	{
		SchoologyResponse response = get(realm + "/enrollments").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyEnrollments.class);
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
	public SchoologyDiscussions getDiscussions(String realm)
	{
		SchoologyResponse response = get(realm + "/discussions").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().asRawData(), SchoologyDiscussions.class);
	}
	
	@Override
	public SchoologyDiscussionReply[] getDiscussionReplies(String realm, String discussion_id)
	{
		SchoologyResponse response = get(realm + "/discussions/" + discussion_id + "/comments").requireSuccess();
		
		return gson.fromJson(response.getBody().parse().get("comment").asRawData(), SchoologyDiscussionReply[].class);
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
