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
@Table(name = "staffPlan")
public class StaffPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long staffPlanId;
	
	@Column(name = "staffId")
	public long staffId;
	
	@Column(name = "staffName")
	public String staffName;
	
	@Column(name = "schedule")
	public String schedule;

	public long getStaffPlanId() {
		return staffPlanId;
	}

	public void setStaffPlanId(long staffPlanId) {
		this.staffPlanId = staffPlanId;
	}

	public long getStaffId() {
		return staffId;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	
}
