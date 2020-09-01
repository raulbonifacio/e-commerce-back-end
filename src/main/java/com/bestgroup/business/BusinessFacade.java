package com.bestgroup.business;

import javax.enterprise.inject.Default;

import com.bestgroup.business.modules.permission.Permission;
import com.bestgroup.business.modules.permission.ValidatePermissionName;
import com.bestgroup.core.Facade;

@Default
public class BusinessFacade extends Facade {

	public BusinessFacade() { 

		onRead(Permission.class, new ValidatePermissionName());
	}
}
