package com.bestgroup.business.handlers.permission;

import com.bestgroup.business.domain.Permission;
import com.bestgroup.business.handlers.util.ValidateString;
import com.bestgroup.core.Handler;

public class ValidatePermissionDescription extends ValidateString {

	public ValidatePermissionDescription(Handler next) {
		super(next, Permission.class::cast, Permission::getDescription, "description");
		this.maxLength = 10;
		this.minLength = 10;
	}

}
