package com.sico.api.checkinline.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CheckOnLineApplicationTests {

	@InjectMocks
	CheckOnLineApplication application;
	@Test
	void infoTest() {
		CheckOnLineApplication.printInfo();
		assertNotNull(application.memInfoRunner());
	}

}
