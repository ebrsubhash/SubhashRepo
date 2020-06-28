package com.quovantis.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.quovantis.assignment.enums.ApplicationStatus;

@Entity
@Table(name="job_application",uniqueConstraints= @UniqueConstraint (columnNames = {"email","offerId"}))
@JsonInclude(Include.NON_NULL)
public class JobApplication {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long jobId;
	@ManyToOne
	@JoinColumn(name="offerId",nullable=false)
	@JsonBackReference
	private JobOffer relatedOffer;	
	private String email;
	private String resumeText;
	@Enumerated(EnumType.STRING)
	private ApplicationStatus status;
	@Transient
	private String jobTitle;
	
	
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	
	public JobOffer getRelatedOffer() {
		return relatedOffer;
	}
	public void setRelatedOffer(JobOffer relatedOffer) {
		this.relatedOffer = relatedOffer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResumeText() {
		return resumeText;
	}
	public void setResumeText(String resumeText) {
		this.resumeText = resumeText;
	}
	
	public ApplicationStatus getStatus() {
		return status;
	}
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
}
