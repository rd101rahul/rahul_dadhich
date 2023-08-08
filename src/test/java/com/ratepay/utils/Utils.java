package com.ratepay.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;

public class Utils {

	// Method to read the JSON request payload from the file
	public static String readRequestBodyFromFile() throws IOException {
		ClassPathResource resource = new ClassPathResource("userRegistration.json");
		return new String(Files.readAllBytes(Paths.get(resource.getURI())));
	}
	
}
