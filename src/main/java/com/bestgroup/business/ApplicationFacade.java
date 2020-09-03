package com.bestgroup.business;

import java.util.Arrays;

import javax.ejb.Singleton;
import javax.enterprise.inject.Default;

import com.bestgroup.business.domain.Permission;
import com.bestgroup.business.handlers.permission.ValidatePermissionDescription;
import com.bestgroup.business.handlers.permission.ValidatePermissionName;
import com.bestgroup.core.HandledFacade;
import com.bestgroup.core.Handler;

@Default
public class ApplicationFacade extends HandledFacade {
	public ApplicationFacade() {
		onCreate(Permission.class,
				Handler.chain(Arrays.asList(ValidatePermissionName::new, ValidatePermissionDescription::new)));
	}
}
