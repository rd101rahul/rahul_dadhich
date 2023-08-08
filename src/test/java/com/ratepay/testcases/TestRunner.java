package com.ratepay.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

// Add the test classes required to be run

@Suite.SuiteClasses({ UserRegistraion.class, UserInfoRetrieval.class, UserRegistrationE2ETest.class})
public class TestRunner {
}
