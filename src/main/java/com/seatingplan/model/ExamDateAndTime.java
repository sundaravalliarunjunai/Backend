package com.seatingplan.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Configuration;

@Configuration
@Entity
@Table(name = "examDateAndTime")

public class ExamDateAndTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long examDateAndTimeId;
	
	@Column(name = "examDateId")
	public long examDateId;
	
	@Column(name = "examNoonType")
	public String examNoonType;
	
	@Column(name = "subjectId")
	public long subjectId;
	
	@CreationTimestamp
    private LocalDateTime createDateTime;
	
	@UpdateTimestamp
    private LocalDateTime updateDateTime;

	public long getExamDateAndTimeId() {
		return examDateAndTimeId;
	}

	public void setExamDateAndTimeId(long examDateAndTimeId) {
		this.examDateAndTimeId = examDateAndTimeId;
	}

	public long getExamDateId() {
		return examDateId;
	}

	public void setExamDateId(long examDateId) {
		this.examDateId = examDateId;
	}

	public String getExamNoonType() {
		return examNoonType;
	}

	public void setExamNoonType(String examNoonType) {
		this.examNoonType = examNoonType;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
}
