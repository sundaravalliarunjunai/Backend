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
@Table(name = "studentPlan")
public class StudentPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long studentPlanId;
	
	@Column(name = "studentId")
	public long studentId;
	
	@Column(name = "studentName")
	public String studentName;
	
	@Column(name = "schedule")
	public String schedule;

	public long getStudentPlanId() {
		return studentPlanId;
	}

	public void setStudentPlanId(long studentPlanId) {
		this.studentPlanId = studentPlanId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
}
