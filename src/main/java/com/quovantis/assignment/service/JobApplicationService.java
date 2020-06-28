package com.quovantis.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quovantis.assignment.entity.JobApplication;
import com.quovantis.assignment.entity.JobOffer;
import com.quovantis.assignment.enums.ApplicationStatus;
import com.quovantis.assignment.repository.JobApplicationRespository;
import com.quovantis.assignment.repository.JobOfferRespository;

@Service
public class JobApplicationService {
	
	@Autowired
	private JobApplicationRespository jobApplicationRespository;
	@Autowired
	private JobOfferRespository jobOfferRespository;

	public void save(JobApplication jobApplication) throws Exception {
		jobApplication.setStatus(ApplicationStatus.APPLIED);
		JobOffer jobOffer = jobOfferRespository.findByJobTitle(jobApplication.getJobTitle());
		if(jobOffer != null) {
			jobApplication.setRelatedOffer(jobOffer);
		}else
			throw new Exception("Offer Not Found with title : "+jobApplication.getJobTitle());
		jobApplicationRespository.save(jobApplication);
	}

	public void update(JobApplication jobApplication) throws Exception {
		
		JobOffer jobOffer = jobOfferRespository.findByJobTitle(jobApplication.getJobTitle());
		if(jobOffer != null) {
			jobApplication.setRelatedOffer(jobOffer);
			JobApplication application = jobApplicationRespository.findByEmailAndRelatedOffer(jobApplication.getEmail(),jobOffer);
			application.setStatus(jobApplication.getStatus());
			jobApplicationRespository.save(application);
		}else
			throw new Exception("Offer Not Found with title : "+jobApplication.getJobTitle());		
		
	}

	public List<JobApplication> findAll() {
		return jobApplicationRespository.findAll();
	}

	public List<JobApplication> findByRelatedOffer(String relatedOffer) {
		JobOffer jobOffer = jobOfferRespository.findByJobTitle(relatedOffer);
		List<JobApplication> jobApplication = jobApplicationRespository.findByRelatedOffer(jobOffer);
		return jobApplication;
	}	

}
