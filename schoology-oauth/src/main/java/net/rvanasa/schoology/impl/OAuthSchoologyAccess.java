package net.rvanasa.schoology.impl;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import net.rvanasa.schoology.SchoologyAccess;
import net.rvanasa.schoology.SchoologyContentType;
import net.rvanasa.schoology.SchoologyResponse;

public class OAuthSchoologyAccess implements SchoologyAccess
{
	private final String key;
	private final String secret;
	
	private String resourceURL = "https://api.schoology.com/v1/";
	
	private SchoologyContentType contentType = SchoologyContentTypeEnum.JSON;
	
	private final OAuthService service;
	
	public OAuthSchoologyAccess(String domain, String key, String secret)
	{
		this.key = key;
		this.secret = secret;
		
		this.service = new ServiceBuilder()
				.provider(new OauthSchoologyApi(domain))
				.apiKey(getClientKey())
				.apiSecret(getClientSecret())
				.signatureType(SignatureType.Header)
				.build();
	}
	
	public String getClientKey()
	{
		return key;
	}
	
	public String getClientSecret()
	{
		return secret;
	}
	
	public OAuthService getOAuthService()
	{
		return service;
	}
	
	public String getResourceURL()
	{
		return resourceURL;
	}
	
	public OAuthSchoologyAccess setResourceURL(String resourceURL)
	{
		this.resourceURL = resourceURL;
		return this;
	}
	
	public SchoologyContentType getContentType()
	{
		return contentType;
	}
	
	public OAuthSchoologyAccess setContentType(SchoologyContentType contentType)
	{
		this.contentType = contentType;
		return this;
	}
	
	public OAuthRequest prepareRequest(Verb verb, String resource)
	{
		OAuthRequest request = new OAuthRequest(Verb.GET, getResourceURL() + resource);
		getOAuthService().signRequest(Token.empty(), request);
		request.addHeader("Accept", getContentType().getID());
		
		return request;
	}
	
	public SchoologyResponse prepareResponse(Response response)
	{
		return new BasicSchoologyResponse(
				SchoologyResponseStatusEnum.getStatus(response.getCode()),
				new BasicSchoologyResponseBody(getContentType(), response.getBody()));
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
		String payload = "<?xml version='1.0' encoding='utf-8' ?><requests>";
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
	public SchoologyResponse options(String resource)
	{
		OAuthRequest request = prepareRequest(Verb.OPTIONS, resource);
		Response response = request.send();
		
		return prepareResponse(response);
	}
}
