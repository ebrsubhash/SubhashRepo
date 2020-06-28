package com.quovantis.assignment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quovantis.assignment.entity.JobApplication;
import com.quovantis.assignment.entity.JobOffer;
import com.quovantis.assignment.service.JobApplicationService;
import com.quovantis.assignment.service.JobOfferService;

@RestController
public class RecruitController {
	
	@Autowired
	private JobApplicationService jobApplicationService;
	@Autowired
	private JobOfferService jobOfferService;
	
	@PostMapping("/applyJob")
	public void apply(@RequestBody JobApplication jobaplication) throws Exception {
		System.out.println();
		jobApplicationService.save(jobaplication);
		
	}
	
	@PostMapping("/createJob")
	public void createJobOffer(@RequestBody JobOffer jobOffer) {
		jobOfferService.save(jobOffer);
	}
	
	@PutMapping("/updateApplicationStatus")
	public void updateAppliccationStatsus(@RequestBody JobApplication jobApplication) throws Exception {
		jobApplicationService.update(jobApplication);
	}

	@GetMapping("/getAllOffers")
	public List<JobOffer> getAllOffers(){
		return jobOfferService.findAll();
	}
	
	@GetMapping("/getOffer/path-variable/{jobTitle}")
	public JobOffer getAllOffers(@PathVariable String jobTitle){
		return jobOfferService.findByJobTitle(jobTitle);
	}
	
	@GetMapping("/getAllApplications")
	public List<JobApplication> getAllApplications(){
		return jobApplicationService.findAll();
	}
	
	@GetMapping("/getApplications/path-variable/{relatedOffer}")
	public List<JobApplication> getAllApplicationForOffer(@PathVariable String relatedOffer){
		return jobApplicationService.findByRelatedOffer(relatedOffer);
	}
}
