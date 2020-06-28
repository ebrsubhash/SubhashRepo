package com.quovantis.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quovantis.assignment.entity.JobApplication;
import com.quovantis.assignment.entity.JobOffer;

@Repository
public interface JobApplicationRespository extends JpaRepository<JobApplication, Long> {

	JobApplication findByEmailAndRelatedOffer(String email, JobOffer jobOffer);

	List<JobApplication> findByRelatedOffer(JobOffer jobOffer);

}
