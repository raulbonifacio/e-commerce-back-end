package com.bestgroup.business.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.bestgroup.core.DomainEntity;

@MappedSuperclass
public class TimestampedEntity extends DomainEntity {

	@Column(columnDefinition = "TIMESTAMP")
	protected LocalDateTime createAt;

	@Column(columnDefinition = "TIMESTAMP")
	protected LocalDateTime updatedAt;

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
