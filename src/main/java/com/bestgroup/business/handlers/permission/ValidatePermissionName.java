package com.bestgroup.business.handlers.permission;

import com.bestgroup.business.domain.Permission;
import com.bestgroup.business.handlers.util.ValidateString;
import com.bestgroup.core.Handler;

public class ValidatePermissionName extends ValidateString {

	public ValidatePermissionName(Handler next) {
		super(next, Permission.class::cast, Permission::getName, "name");
	}
}
