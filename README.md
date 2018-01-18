# schoology-api
Java API and implementation for Schoology (https://schoology.com)

Behold, a straightforward 2- and 3-legged wrapper for the Schoology REST API. 

Make sure to use the `schoology-oauth` module for the actual OAuth ([Scribe](https://github.com/scribejava/scribejava)) implementation. 
 
## Example Usage:

#### 3-Legged Auth:

```java

SchoologyFlow flow = new OAuthSchoologyFlow(DISTRICT, KEY, SECRET, CALLBACK);

SchoologyToken token = flow.createRequestToken();

String authUrl = token.getAuthorizationUrl();

// Redirect client...

String verifier = "[Response from callback URL]";

SchoologyRequestHandler schoology = token.createRequestHandler(verifier);

```

#### 2-Legged Auth:

```java

SchoologyRequestHandler schoology = new OAuthSchoologyRequestHandler(new BasicOAuthResourceLocator(DISTRICT_PREFIX), API_KEY, API_SECRET);

```

#### Sending a Request:

```java

SchoologyResponseBody response = schoology.get("sections/123456789").requireSuccess().getBody();

System.out.println(response.getRawData()); // JSON string

SchoologyNode node = response.parse();
System.out.println(node.get("JSON_KEY").get(1).asString()); // index 1 of some JSON_KEY property

```

You can generate and API key and secret by going to https://'[DISTRICT_PREFIX].schoology.com/api'

By the way, this is way more straightforward than Schoology's official PHP SDK and only supports two-legged OAuth. If you need any additional features, feel free to send me an email with some info regarding your potential use case. 
