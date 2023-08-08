package com.ratepay.testcases;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ratepay.utils.Constants;



@SpringBootTest
public class UserInfoRetrieval {
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	String requestBody;
	
	@Test
    public void getValidUserDetails() {
		
		ResponseEntity<String> response  = restTemplate.getForEntity(Constants.baseUriRetrieval, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
    public void getInvalidUserDetails() {
		
		ResponseEntity<String> response  = restTemplate.getForEntity(Constants.baseUriRetrievalInvalidUser, String.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		
	}

}
