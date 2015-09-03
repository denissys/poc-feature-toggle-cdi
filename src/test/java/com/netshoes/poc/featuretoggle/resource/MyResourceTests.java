package com.netshoes.poc.featuretoggle.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.netshoes.poc.featuretoggle.commons.AbstractEmbeddedServer;

/**
 * Functional test
 */
public class MyResourceTests extends AbstractEmbeddedServer {

	private static final String URL = "http://localhost:8080/my-app/api/test";

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void httpGet_setFeatureEnabled_returnAlternativeMessage() {
		final RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headers.set("feature-enable-happy-message", "true");
		final HttpEntity entity = new HttpEntity(headers);
		final ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Feature toggle turn on :)", responseEntity.getBody());
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void httpGet_setFeatureDisabled_returnDefaultMessage() {
		final RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headers.set("feature-enable-happy-message", "false");
		final HttpEntity entity = new HttpEntity(headers);
		final ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Feature toggle turn off :(", responseEntity.getBody());
	}
	
	@Test
	public void httpGet_defaultFeatureValue_returnDefaultMessage() {
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(URL, String.class);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Feature toggle turn off :(", responseEntity.getBody());
	}

}

