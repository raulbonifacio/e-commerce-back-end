package com.bestgroup.core.handler;

import com.bestgroup.business.modules.permission.Permission;
import com.bestgroup.core.Handler;
import com.bestgroup.core.Payload;
import com.bestgroup.core.exception.HandlerException;

public class ValidateString extends ValidationHandler {

	protected int max;
	protected int min;
	protected boolean trim;

	public ValidateString(Handler nextHandler) {
		super(nextHandler);
		this.max = Integer.MAX_VALUE;
		this.min = Integer.MIN_VALUE;
		this.trim = true;
	}

	@Override
	public Payload validate(Payload payload) throws HandlerException {

		payload = super.validate(payload);

		if (payload.getErrors().containsKey(this.field)) {
			return payload;
		}

		Object value = this.getField((Permission) payload.getEntity());

		if (value instanceof String) {

			String stringValue = (String) value;

			if (this.trim) {
				stringValue.trim();
			}

			if (stringValue.length() > this.max || stringValue.length() < this.min) {
				payload.getErrors().putIfAbsent(this.field, String.format(
						"The field '%s' must be between '%d' and '%d' characters", this.field, this.min, this.max));
			}

		} else {
			payload.getErrors().putIfAbsent(this.field, String.format("The field '%s' is not a string.", this.field));
		}

		return payload;
	}

}
