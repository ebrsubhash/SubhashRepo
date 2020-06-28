package com.quovantis.assigment.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.quovantis.assignment.repository.JobOfferRespository;
import com.quovantis.assignment.service.JobOfferService;

@ExtendWith(MockitoExtension.class)
class JobOfferServiceTest {
	
	@Mock
	private JobOfferRespository jobOfferRespository;
	
	@InjectMocks
	private JobOfferService jobOfferService;

	@Test
	void save() {
		
		fail("Not yet implemented");
	}

}
