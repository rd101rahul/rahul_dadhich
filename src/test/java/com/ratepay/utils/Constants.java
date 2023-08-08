package com.ratepay.utils;

public class Constants {
	
	public static String baseUriRegistration = "http://localhost:" + 8080 + "/registration";
	
	public static String testUsernameValid = "testuser01";
	public static String testPasswordValid = "Pass@123";
	public static String testUsernameInvalid  = "user";
	public static String testUsernameInactive  = "User000";
	
	public static String baseUriRetrieval = "http://localhost:" + 8080 + "/users/"+testUsernameValid+"";
	public static String baseUriRetrievalInvalidUser = "http://localhost:" + 8080 + "/users/"+testUsernameInactive+"";
}
