package com.bestgroup.business.modules.permission;

import com.bestgroup.core.Handler;
import com.bestgroup.core.Payload;
import com.bestgroup.core.Result;
import com.bestgroup.core.exception.HandlerException;

public class ValidatePermissionName extends Handler{

	@Override
	public Result handle(Payload payload) throws HandlerException{

		payload.getErrors().put("error", "An error in here sir");

		return super.handle(payload);
	}
}
