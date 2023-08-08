package com.ratepay.testcases;

import static org.junit.Assert.*;

import java.io.IOException;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ratepay.utils.Constants;
import com.ratepay.utils.Utils;

@SpringBootTest
public class UserRegistraion {
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	String requestBody;

	@Test
	
	// To verify registration of user is successful using the valid parameters and API
	public void testUserRegistration() throws IOException {

		// Read the JSON request payload from the file
		String requestBody = Utils.readRequestBodyFromFile();

		requestBody = requestBody.replace("${testUsernameVariable}", Constants.testUsernameValid)
				.replace("${testPasswordVariable}", Constants.testPasswordValid);

		headers.add("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> responseEntity = restTemplate.postForEntity(Constants.baseUriRegistration, requestEntity, String.class);
		System.out.println(responseEntity.getStatusCode());
		// Check the response status code
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}

	@Test
	
	// To verify registration of user with username less that 6 characters
	public void invaidUserRegistration() throws IOException {

		// Read the JSON request payload from the file
		String requestBody = Utils.readRequestBodyFromFile();

		requestBody = requestBody.replace("${testUsernameVariable}", Constants.testUsernameInvalid)
				.replace("${testPasswordVariable}", Constants.testPasswordValid);

		headers.add("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> responseEntity = restTemplate.postForEntity(Constants.baseUriRegistration, requestEntity, String.class);

		
		// Check the response status code
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
		
		// Verify the message in response body
		assertEquals(responseEntity.getBody(), "username is not valid");

	}
	
	@Test
	
	// To verify registration of user with existing username
	public void exisitngUserRegistration() throws IOException {

		// Read the JSON request payload from the file
		String requestBody = Utils.readRequestBodyFromFile();

		requestBody = requestBody.replace("${testUsernameVariable}", Constants.testUsernameValid)
				.replace("${testPasswordVariable}", Constants.testPasswordValid);

		headers.add("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> responseEntity = restTemplate.postForEntity(Constants.baseUriRegistration, requestEntity, String.class);
		// Check the response status code
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
		
		System.out.println(responseEntity.getBody());
		// Verify the message in response body
		assertEquals(responseEntity.getBody(), "User already registered");

	}
	
	@Test
	
	// To verify registration of user with invalid format of request
	public void invalidUserRequest() throws IOException {


		// Read the JSON request payload from the file
		String requestBody = Utils.readRequestBodyFromFile();

		requestBody = requestBody.replace("${testUsernameVariable}", Constants.testUsernameInactive).replace(",", " ")
				.replace("${testPasswordVariable}", Constants.testPasswordValid);

		headers.add("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> responseEntity = restTemplate.postForEntity(Constants.baseUriRegistration, requestEntity, String.class);
		System.out.println(responseEntity.getStatusCode());
		// Check the response status code
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
		
	}
	
}
