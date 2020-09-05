package com.bestgroup.business.strategies.permission;

import com.bestgroup.business.domain.Permission;
import com.bestgroup.business.strategies.util.ValidateString;

public class ValidatePermissionName extends ValidateString {

	public ValidatePermissionName() {
		super(Permission.class::cast, Permission::getName, "name");
	}
}
