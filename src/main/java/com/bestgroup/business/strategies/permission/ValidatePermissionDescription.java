package com.bestgroup.business.strategies.permission;

import com.bestgroup.business.domain.Permission;
import com.bestgroup.business.strategies.util.ValidateString;

public class ValidatePermissionDescription extends ValidateString {

	public ValidatePermissionDescription() {
		super(Permission.class::cast, Permission::getDescription, "description");
		this.maxLength = 10;
		this.minLength = 10;
	}

}
