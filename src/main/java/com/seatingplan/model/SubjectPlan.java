package com.seatingplan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Configuration;

@Configuration
@Entity
@Table(name = "subjectPlan")
public class SubjectPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long subjectPlanId;
	
	@Column(name = "subjectId")
	public long subjectId;
	
	@Column(name = "subjectName")
	public String subjectName;
	
	@Column(name = "examDateAndTimeId")
	public long examDateAndTimeId;
	
	@Column(name = "summary")
	public String summary;

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getExamDateAndTimeId() {
		return examDateAndTimeId;
	}

	public void setExamDateAndTimeId(long examDateAndTimeId) {
		this.examDateAndTimeId = examDateAndTimeId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public long getSubjectPlanId() {
		return subjectPlanId;
	}

	public void setSubjectPlanId(long subjectPlanId) {
		this.subjectPlanId = subjectPlanId;
	}
	
	
}
