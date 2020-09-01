package com.bestgroup.core.handler;

import java.lang.reflect.Field;

import com.bestgroup.core.Entity;
import com.bestgroup.core.Handler;
import com.bestgroup.core.Payload;
import com.bestgroup.core.Result;
import com.bestgroup.core.exception.HandlerException;

public abstract class ValidationHandler extends Handler {

	protected String field;

	public ValidationHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	public Result handle(Payload payload) throws HandlerException {
		return super.handle(this.validate(payload));
	}

	public Object getField(String field, Object object) throws HandlerException {
		try {
			Field objectField = object.getClass().getField(this.field);
			objectField.setAccessible(true);
			return objectField.get(object);
		} catch (Exception exception) {
			throw new HandlerException(exception);
		}
	}

	public Object getField(Object object) throws HandlerException {
		return this.getField(this.field, object);
	}

	public Payload validate(Payload payload) throws HandlerException {
		return payload;
	}
}
