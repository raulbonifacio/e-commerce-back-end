package com.bestgroup.business.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class AccessProtectedEntity extends SoftDeletableEntity {

	@Transient
	protected User user;
}
