package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Child_Details")
public class Child {
	
	@Id
	private int babyid;
	private String babyFName;
	private String babyLName;
	private String FatherName;
	private String MotherName;
	private String Address;
	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Child(int babyid, String babyFName, String babyLName, String fatherName, String motherName, String address) {
		super();
		this.babyid = babyid;
		this.babyFName = babyFName;
		this.babyLName = babyLName;
		FatherName = fatherName;
		MotherName = motherName;
		Address = address;
	}
	public int getBabyid() {
		return babyid;
	}
	public void setBabyid(int babyid) {
		this.babyid = babyid;
	}
	public String getBabyFName() {
		return babyFName;
	}
	public void setBabyFName(String babyFName) {
		this.babyFName = babyFName;
	}
	public String getBabyLName() {
		return babyLName;
	}
	public void setBabyLName(String babyLName) {
		this.babyLName = babyLName;
	}
	public String getFatherName() {
		return FatherName;
	}
	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}
	public String getMotherName() {
		return MotherName;
	}
	public void setMotherName(String motherName) {
		MotherName = motherName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
