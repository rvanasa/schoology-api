package net.rvanasa.schoology.impl;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import net.rvanasa.schoology.SchoologyContentType;
import net.rvanasa.schoology.SchoologyRequestHandler;
import net.rvanasa.schoology.SchoologyResponse;

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
		OAuthRequest request = new OAuthRequest(verb, getResourceLocator().getRequestUrl(resource));
		getOAuthService().signRequest(getAccessToken() != null ? getAccessToken() : Token.empty(), request);
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
	public SchoologyResponse options(String resource)
	{
		OAuthRequest request = prepareRequest(Verb.OPTIONS, resource);
		Response response = request.send();
		
		return prepareResponse(response);
	}
}
