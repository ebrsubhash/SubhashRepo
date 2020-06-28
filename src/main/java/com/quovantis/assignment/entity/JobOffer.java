package com.quovantis.assignment.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "job_offer", uniqueConstraints = @UniqueConstraint(columnNames = { "jobTitle" }))
@JsonInclude(Include.NON_NULL)
public class JobOffer implements Serializable {

	private static final long serialVersionUID = -5544105924049774899L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long offerId;
	private String jobTitle;
	private String startDate;
	private Long numberOfApplication;
	@OneToMany(mappedBy = "relatedOffer", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<JobApplication> jobAplications;

	
	
	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Long getNumberOfApplication() {
		return numberOfApplication;
	}

	public void setNumberOfApplication(Long numberOfApplication) {
		this.numberOfApplication = numberOfApplication;
	}

	public List<JobApplication> getJobAplications() {
		return jobAplications;
	}

	public void setJobAplications(List<JobApplication> jobAplications) {
		this.jobAplications = jobAplications;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime * result + ((numberOfApplication == null) ? 0 : numberOfApplication.hashCode());
		result = prime * result + (int) (offerId ^ (offerId >>> 32));
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobOffer other = (JobOffer) obj;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (numberOfApplication == null) {
			if (other.numberOfApplication != null)
				return false;
		} else if (!numberOfApplication.equals(other.numberOfApplication))
			return false;
		if (offerId != other.offerId)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

}
