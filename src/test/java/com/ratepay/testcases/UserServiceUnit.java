package com.ratepay.testcases;


import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ratepay.test.repository.UserRepository;
import com.ratepay.test.service.UserService;

public class UserServiceUnit {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Test
	public void testSaveUser() {
		//User user = new User("moonuser1", "Pass@123");

		//userService.save(user);

		//verify(userRepository, times(1)).save(user);
	}

}
