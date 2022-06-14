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
@Table(name = "roomPlan")

public class RoomPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long roomPlanId;
	
	@Column(name = "roomId")
	public long roomId;
	
	@Column(name = "roomName")
	public String roomName;
		
	@Column(name = "schedule")
	public String schedule;

	public long getRoomPlanId() {
		return roomPlanId;
	}

	public void setRoomPlanId(long roomPlanId) {
		this.roomPlanId = roomPlanId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	
}
