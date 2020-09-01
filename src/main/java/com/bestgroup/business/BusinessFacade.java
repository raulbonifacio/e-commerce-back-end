package com.bestgroup.business;

import java.util.Arrays;

import javax.enterprise.inject.Default;

import com.bestgroup.business.modules.permission.Permission;
import com.bestgroup.business.modules.permission.ValidatePermissionDescription;
import com.bestgroup.business.modules.permission.ValidatePermissionName;
import com.bestgroup.core.Facade;
import com.bestgroup.core.Handler;

@Default
public class BusinessFacade extends Facade {

	public BusinessFacade() {

		onRead(Permission.class, Handler.chain(Arrays.asList(
			ValidatePermissionName::new,
			ValidatePermissionDescription::new
		)));
	}
}
