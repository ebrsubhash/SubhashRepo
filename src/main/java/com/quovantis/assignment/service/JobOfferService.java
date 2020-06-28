package com.quovantis.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quovantis.assignment.entity.JobOffer;
import com.quovantis.assignment.repository.JobOfferRespository;

@Service
public class JobOfferService {
	
	@Autowired
	private JobOfferRespository jobOfferRespository;

	public void save(JobOffer jobOffer) {
		jobOfferRespository.save(jobOffer);
	}

	public List<JobOffer> findAll() {
		return jobOfferRespository.findAll();
	}

	public JobOffer findByJobTitle(String jobTitle) {
		return jobOfferRespository.findByJobTitle(jobTitle);
	}
	
}
