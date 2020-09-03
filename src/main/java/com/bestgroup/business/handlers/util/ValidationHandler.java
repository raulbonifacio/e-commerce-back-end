package com.bestgroup.business.handlers.util;

import java.util.function.Function;

import com.bestgroup.core.DomainEntity;
import com.bestgroup.core.Handler;
import com.bestgroup.core.Payload;
import com.bestgroup.core.Result;
import com.bestgroup.core.exception.HandlerException;

public abstract class ValidationHandler<V> extends Handler {

	protected String fieldName;
	protected Function<DomainEntity, V> getter;

	public <T extends DomainEntity> ValidationHandler(Handler next, Function<DomainEntity, ? extends  T> typeConverter, Function<T, V> getter, String fieldName) {
		super(next);
		this.fieldName = fieldName;
		this.getter = entity -> getter.apply(typeConverter.apply(entity));
	}

	@Override
	public Result handle(Payload payload) throws HandlerException {
		return super.handle(this.validate(payload));
	}

	public Payload validate(Payload payload) throws HandlerException {
		return payload;
	}
}
