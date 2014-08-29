package com.viafirma.mobile.services.sdk.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.Response.Status.Family;

import com.fasterxml.jackson.databind.JavaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.oauth.client.OAuthClientFilter;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;

public class ApiInvoker {
    private static ApiInvoker INSTANCE = new ApiInvoker();
    private Map<String, Client> hostMap = new HashMap<String, Client>();
    private Map<String, String> defaultHeaderMap = new HashMap<String, String>();
    private boolean isDebug = false;

    public void enableDebug() {
	isDebug = true;
    }

    public static ApiInvoker getInstance() {
	return INSTANCE;
    }

    public void addDefaultHeader(String key, String value) {
	defaultHeaderMap.put(key, value);
    }

    public String escapeString(String str) {
	try{
	    return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
	}
	catch(UnsupportedEncodingException e) {
	    return str;
	}
    }

    public static Object deserialize(String json, String containerType, Class cls) throws ApiException {
	try{
	    if("List".equals(containerType) || "Array".equals(containerType)) {
		JavaType typeInfo = JsonUtil.getJsonMapper().getTypeFactory().constructCollectionType(List.class, cls);
		List response = (List<?>) JsonUtil.getJsonMapper().readValue(json, typeInfo);
		return response;
	    }
	    else if(String.class.equals(cls)) {
		if(json != null && json.startsWith("\"") && json.endsWith("\"") && json.length() > 1) {
		    return json.substring(1, json.length() - 1);
		} else {
		    return json;
		}
	    }
	    else {
		return JsonUtil.getJsonMapper().readValue(json, cls);
	    }
	}
	catch (IOException e) {
	    throw new ApiException(500, e.getMessage());
	}
    }

    public static String serialize(Object obj) throws ApiException {
	try {
	    if (obj != null) {
		return JsonUtil.getJsonMapper().writeValueAsString(obj);
	    } else {
		return null;
	    }
	}
	catch (Exception e) {
	    throw new ApiException(500, e.getMessage());
	}
    }

    public String invokeJsonAPI(String host, String consumerKey, String consumerSecret, String token, String tokenSecret, String path, String method, Map<String, String> queryParams, Object body, Map<String, String> headerParams, Map<String, String> formParams, String contentType, Boolean validateResponse) throws ApiException {
	ClientResponse response = invokeAPI(host, consumerKey, consumerSecret, token, tokenSecret, path, method, queryParams, body, headerParams, formParams, contentType);
	String result = response.getEntity(String.class);
	result = (String) ApiInvoker.deserialize(result, "", String.class);
	if(validateResponse && hasValidSignature(response))
	{
	    try {

		if(tokenSecret != null){
		    validateRFC2104HMAC(result.getBytes("UTF-8"), tokenSecret, response.getHeaders().get("Signature-Body").get(0));
		}else{
		    validateRFC2104HMAC(result.getBytes("UTF-8"), consumerSecret, response.getHeaders().get("Signature-Body").get(0));
		}
	    } catch (UnsupportedEncodingException e) {
		throw new ApiException(500, "Unsupported encoding");
	    }
	}
	return result;
    }

    public byte[] invokeFileAPI(String host, String consumerKey, String consumerSecret, String token, String tokenSecret, String path, String method, Map<String, String> queryParams, Object body, Map<String, String> headerParams, Map<String, String> formParams, String contentType, Boolean validateResponse) throws ApiException {
	try {
	    ClientResponse response = invokeAPI(host, consumerKey, consumerSecret, token, tokenSecret, path, method, queryParams, body, headerParams, formParams, contentType);			
	    byte[] resp = toByteArray(response.getEntityInputStream());			
	    if(validateResponse && hasValidSignature(response))
	    {	
		if(tokenSecret != null){
		    validateRFC2104HMAC(resp, tokenSecret, response.getHeaders().get("Signature-Body").get(0));
		}else{
		    validateRFC2104HMAC(resp, consumerSecret, response.getHeaders().get("Signature-Body").get(0));
		}
	    }
	    return resp;
	} catch (IOException e) {
	    throw new ApiException(500, "Error getting file");
	}
    }
    /**
     * Check if this response contains Signature-Body header and if exists, is not empty
     * @param response 
     * @return true if "Signature-Body" header exists and is not empty, false otherwise
     */
    public boolean hasValidSignature(ClientResponse response)
    {
	List<String> signatureBodyHeader=response.getHeaders().get("Signature-Body");
	return signatureBodyHeader!=null && signatureBodyHeader.size()==1 && !signatureBodyHeader.get(0).trim().equals("");	
    }


    private ClientResponse invokeAPI(String host, String consumerKey, String consumerSecret, String token, String tokenSecret, String path, String method, Map<String, String> queryParams, Object body, Map<String, String> headerParams, Map<String, String> formParams, String contentType) throws ApiException {
	Client client = getClient(host);

	StringBuilder b = new StringBuilder();

	for(String key : queryParams.keySet()) {
	    String value = queryParams.get(key);
	    if (value != null){
		if(b.toString().length() == 0) {
		    b.append("?");
		} else {
		    b.append("&");
		}
		b.append(escapeString(key)).append("=").append(escapeString(value));
	    }
	}

	String querystring = b.toString();

	OAuthParameters params = new OAuthParameters().signature("HAMC-SHA1").consumerKey(consumerKey);
	if (token != null) {
	    params.setToken(token);
	}
	OAuthSecrets secrets = new OAuthSecrets().consumerSecret(consumerSecret);
	if (tokenSecret != null) {
	    secrets.setTokenSecret(tokenSecret);
	}
	OAuthClientFilter filter = new OAuthClientFilter(client.getProviders(), params, secrets);
	WebResource resource = client.resource(host + path + querystring);
	resource.addFilter(filter);
	Builder builder = resource.accept("application/json");

	for(String key : headerParams.keySet()) {
	    builder.header(key, headerParams.get(key));
	}

	for(String key : defaultHeaderMap.keySet()) {
	    if(!headerParams.containsKey(key)) {
		builder.header(key, defaultHeaderMap.get(key));
	    }
	}
	ClientResponse response = null;

	if("GET".equals(method)) {
	    response = builder.get(ClientResponse.class);
	}
	else if ("POST".equals(method)) {
	    if("application/x-www-form-urlencoded".equals(contentType)) {
		StringBuilder formParamBuilder = new StringBuilder();

		// encode the form params
		for(String key : formParams.keySet()) {
		    String value = formParams.get(key);
		    if(value != null && !"".equals(value.trim())) {
			if(formParamBuilder.length() > 0) {
			    formParamBuilder.append("&");
			}

			try {
			    formParamBuilder.append(URLEncoder.encode(key, "utf8")).append("=").append(URLEncoder.encode(value, "utf8"));
			}
			catch (Exception e) {
			    // move on to next
			}
		    }
		}
		response = builder.type(contentType).post(ClientResponse.class, formParamBuilder.toString());
	    }else{
		response = builder.type(contentType).post(ClientResponse.class, serialize(body));
	    }
	}
	else if ("PUT".equals(method)) {
	    if(body == null) {
		response = builder.put(ClientResponse.class, serialize(body));
	    } else {
		if("application/x-www-form-urlencoded".equals(contentType)) {
		    StringBuilder formParamBuilder = new StringBuilder();

		    // encode the form params
		    for(String key : formParams.keySet()) {
			String value = formParams.get(key);
			if(value != null && !"".equals(value.trim())) {
			    if(formParamBuilder.length() > 0) {
				formParamBuilder.append("&");
			    }
			    try {
				formParamBuilder.append(URLEncoder.encode(key, "utf8")).append("=").append(URLEncoder.encode(value, "utf8"));
			    }
			    catch (Exception e) {
				// move on to next
			    }
			}
		    }
		    response = builder.type(contentType).put(ClientResponse.class, formParamBuilder.toString());
		} else {
		    response = builder.type(contentType).put(ClientResponse.class, serialize(body));
		}
	    }
	}
	else if ("DELETE".equals(method)) {
	    if(body == null) {
		response = builder.delete(ClientResponse.class, serialize(body));
	    } else {
		response = builder.type(contentType).delete(ClientResponse.class, serialize(body));
	    }
	}
	else {
	    throw new ApiException(500, "unknown method type " + method);
	}
	if(response.getClientResponseStatus() == ClientResponse.Status.NO_CONTENT) {
	    return null;
	}
	else if(response.getClientResponseStatus().getFamily() == Family.SUCCESSFUL) {
	    return response;
	}
	else {
	    throw new ApiException(
		    response.getClientResponseStatus().getStatusCode(),
		    response.getEntity(String.class));
	}
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
	ByteArrayOutputStream buffer = new ByteArrayOutputStream();

	int nRead;
	byte[] data = new byte[1024 * 4];

	while ((nRead = input.read(data, 0, data.length)) != -1) {
	    buffer.write(data, 0, nRead);
	}

	buffer.flush();
	return buffer.toByteArray();
    }

    public void validateRFC2104HMAC(byte[] data, String key, String hash) throws ApiException {

	try {
	    String signature = calculateRFC2104HMAC(data, key);
	    if(!hash.equals(signature)){
		throw new ApiException(500, "Invalid HmacSHA1");
	    }
	    System.out.println("Validate response signature OK");
	} catch (NoSuchAlgorithmException e) {
	    throw new ApiException(500, "No Such Algorithm");
	} catch (InvalidKeyException e) {
	    throw new ApiException(500, "Invalid Key");
	} catch (SignatureException e) {
	    throw new ApiException(500, "Invalid Signature");
	}

    }

    public String calculateRFC2104HMAC(byte[] data, String key)
	    throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
    {
	SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
	Mac mac = Mac.getInstance("HmacSHA1");
	mac.init(signingKey);
	String signature = toHexString(mac.doFinal(data));
	//	System.out.println("KEY: " + key);
	//	System.out.println("Signature: " + signature);
	//	System.out.println("DATA: " + data.length);
	//	System.out.println("STRING: " + new String(data));
	return signature;
    }

    private String toHexString(byte[] bytes) {

	Formatter formatter = new Formatter();

	for (byte b : bytes) {
	    formatter.format("%02x", b);
	}
	String hexString = new String(formatter.toString());
	formatter.close();

	return hexString;
    }

    private Client getClient(String host) {
	if(!hostMap.containsKey(host)) {
	    Client client = Client.create();
	    if(isDebug) {
		client.addFilter(new LoggingFilter());
	    }
	    hostMap.put(host, client);
	}
	return hostMap.get(host);
    }
}

