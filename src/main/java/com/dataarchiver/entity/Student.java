package com.dataarchiver.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	public Student() {

	}

	public Student(String name, Date createdAt) {
		super();
		this.name = name;
		this.createdAt = createdAt;
	}

	@Id
	private Integer id;

	private String name;

	@Column(name = "created_at")
	private Date createdAt = new Date();

	@Column(name = "archival_created_at")
	private Date archivalCreatedAt = new Date();

	public Integer getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
