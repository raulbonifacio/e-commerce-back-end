package com.bestgroup.business;

import java.util.Arrays;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.bestgroup.business.domain.Permission;
import com.bestgroup.business.handlers.permission.ValidatePermissionDescription;
import com.bestgroup.business.handlers.permission.ValidatePermissionName;
import com.bestgroup.core.Facade;
import com.bestgroup.core.Handler;

@Default
public class ApplicationFacade extends Facade {
	public ApplicationFacade() {
		onCreate(Permission.class,
				Handler.chain(Arrays.asList(ValidatePermissionName::new, ValidatePermissionDescription::new)));
	}
}
