package com.dataarchiver.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class ArchivalDeletionStrategy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "created_at")
	private Date createdAt = new Date();

	@Column(name = "archive_unit")
	@Enumerated(EnumType.STRING)
	private TimeUnit archiveUnit;

	@Column(name = "archive_value")
	private Integer archiveValue;

	private String tableName;

	public Integer getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public TimeUnit getArchiveUnit() {
		return archiveUnit;
	}

	public Integer getArchiveValue() {
		return archiveValue;
	}

	public String getTableName() {
		return tableName;
	}

	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}

	@Override
	public String toString() {
		return "ArchivalDeletionStrategy [id=" + id + ", createdAt=" + createdAt + ", archiveUnit=" + archiveUnit
				+ ", archiveValue=" + archiveValue + ", tableName=" + tableName + "]";
	}

}
