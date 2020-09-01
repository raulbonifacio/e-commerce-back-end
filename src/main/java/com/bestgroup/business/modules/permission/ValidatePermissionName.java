package com.bestgroup.business.modules.permission;

import com.bestgroup.core.Handler;
import com.bestgroup.core.Payload;
import com.bestgroup.core.exception.HandlerException;
import com.bestgroup.core.handler.ValidationHandler;

public class ValidatePermissionName extends ValidationHandler {

	public ValidatePermissionName(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	public Payload validate(Payload payload) throws HandlerException {
		System.out.println("Validating permission name.");
		return super.validate(payload);
	}

}