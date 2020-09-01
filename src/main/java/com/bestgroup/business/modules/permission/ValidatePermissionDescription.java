package com.bestgroup.business.modules.permission;

import com.bestgroup.core.Handler;
import com.bestgroup.core.Payload;
import com.bestgroup.core.exception.HandlerException;
import com.bestgroup.core.handler.ValidationHandler;

public class ValidatePermissionDescription extends ValidationHandler {

	public ValidatePermissionDescription(Handler nextHandler) {
		super(nextHandler);
	}
	
	@Override
	public Payload validate(Payload payload) throws HandlerException {
		System.out.println("Validating permission description.");
		return super.validate(payload);
	}
}
