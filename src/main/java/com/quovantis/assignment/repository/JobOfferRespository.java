package com.quovantis.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quovantis.assignment.entity.JobOffer;

@Repository
public interface JobOfferRespository extends JpaRepository<JobOffer, Long> {

	
	JobOffer findByJobTitle(String jobTitle);

}
