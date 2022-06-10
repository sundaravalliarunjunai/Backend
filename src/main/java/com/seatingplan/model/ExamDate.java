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
@Table(name = "examDate")

public class ExamDate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long examDateId;
	
	@Column(name = "date")
	public String date;
	
	@Column(name = "examNoonType")
	public String examNoonType;
	
	@Column(name = "foreNoonStartingTime")
	public String foreNoonStartingTime;
	
	@Column(name = "foreNoonEndingTime")
	public String foreNoonEndingTime;
	
	@Column(name = "afterNoonStartingTime")
	public String afterNoonStartingTime;
	
	@Column(name = "afterNoonEndingTime")
	public String afterNoonEndingTime;
	
	@CreationTimestamp
    private LocalDateTime createDateTime;
 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

	public long getExamDateId() {
		return examDateId;
	}

	public void setExamDateId(long examDateId) {
		this.examDateId = examDateId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExamNoonType() {
		return examNoonType;
	}

	public void setExamNoonType(String examNoonType) {
		this.examNoonType = examNoonType;
	}

	public String getForeNoonStartingTime() {
		return foreNoonStartingTime;
	}

	public void setForeNoonStartingTime(String foreNoonStartingTime) {
		this.foreNoonStartingTime = foreNoonStartingTime;
	}

	public String getForeNoonEndingTime() {
		return foreNoonEndingTime;
	}

	public void setForeNoonEndingTime(String foreNoonEndingTime) {
		this.foreNoonEndingTime = foreNoonEndingTime;
	}

	public String getAfterNoonStartingTime() {
		return afterNoonStartingTime;
	}

	public void setAfterNoonStartingTime(String afterNoonStartingTime) {
		this.afterNoonStartingTime = afterNoonStartingTime;
	}

	public String getAfterNoonEndingTime() {
		return afterNoonEndingTime;
	}

	public void setAfterNoonEndingTime(String afterNoonEndingTime) {
		this.afterNoonEndingTime = afterNoonEndingTime;
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
