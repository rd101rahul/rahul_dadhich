package com.ratepay.testcases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ratepay.test.model.User;
import com.ratepay.test.repository.UserRepository;
import com.ratepay.utils.Constants;


@SpringBootTest
public class UserRegistrationE2ETest {
	TestRestTemplate restTemplate = new TestRestTemplate();


	@Test
	public void testUserRegistration() throws IOException {

		String username = "E2EUser01";
        String password = "Pass@123";

        User request = new User();
        request.setUsername(username);
        request.setPassword(password);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<User> requestEntity = new HttpEntity<>(request, headers);

        // Make the API call
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(Constants.baseUriRegistration, requestEntity, String.class);

        // Verify the API response
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        
        //Additionally we can verify the Database Entry for the record
		

	}

}
