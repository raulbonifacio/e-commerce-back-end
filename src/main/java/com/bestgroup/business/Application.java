package com.bestgroup.business;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.bestgroup.business.domain.Permission;
import com.bestgroup.business.strategies.permission.ValidatePermissionDescription;
import com.bestgroup.business.strategies.permission.ValidatePermissionName;
import com.bestgroup.business.strategies.util.CreateEntity;
import com.bestgroup.business.strategies.util.ReadEntities;
import com.bestgroup.business.strategies.util.UpdateEntity;
import com.bestgroup.core.Facade;

@Default
public class Application extends Facade {

	@Inject
	protected CreateEntity createEntity;

	@Inject
	protected UpdateEntity updateEntity;

	@Inject
	protected ReadEntities readEntities;

	@Inject
	protected ValidatePermissionName validatePermissionName;

	@Inject
	protected ValidatePermissionDescription validatePermissionDescription;

	@PostConstruct
	public void configureAplication() {

		this.onCreate(Permission.class, Arrays.asList(
			validatePermissionName,
			validatePermissionDescription,
			createEntity
		));

		this.onUpdate(Permission.class, Arrays.asList(
			validatePermissionName,
			validatePermissionDescription,
			updateEntity
		));

		this.onRead(Permission.class, Arrays.asList(readEntities));
	}

}
