package com.bestgroup.business.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SoftDeletableEntity extends TimestampedEntity {

	@Column(columnDefinition = "TIMESTAMP")
	protected LocalDateTime deletedAt;

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

}
