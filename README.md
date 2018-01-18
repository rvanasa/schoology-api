# schoology-api
Java API and implementation for Schoology (https://schoology.com)

Behold, a straightforward two- and three-legged authentication wrapper for the Schoology REST API. 

Make sure to use the `schoology-oauth` module for the actual OAuth ([Scribe](https://github.com/scribejava/scribejava)) implementation. 
 
## Example Usage:

#### 3-Legged Auth:

```java

SchoologyFlow flow = new OAuthSchoologyFlow(DISTRICT_PREFIX, API_KEY, API_SECRET, CALLBACK_URL);

SchoologyToken token = flow.createRequestToken();

String authUrl = token.getAuthorizationUrl();

// redirect client...

String verifier = "[Response from callback URL]";

SchoologyRequestHandler schoology = token.createRequestHandler(verifier);

```

#### 2-Legged Auth:

You can generate a user API key/secret by going to `https://{DISTRICT_PREFIX}.schoology.com/api`

```java

SchoologyRequestHandler schoology = new OAuthSchoologyRequestHandler(DISTRICT_PREFIX, API_KEY, API_SECRET);

```

#### Sending a Request:

```java

SchoologyResponseBody response = schoology.get("sections/123456789").requireSuccess().getBody();

System.out.println(response.getRawData()); // JSON string

SchoologyNode node = response.parse();
System.out.println(node.get("JSON_KEY").get(1).asString()); // index 1 of some JSON_KEY property

```

I have been making gradual improvements as people continue to use this API. If you need any additional features, feel free to send me an email with some info regarding your potential use case. 
