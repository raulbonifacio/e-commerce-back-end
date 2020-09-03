package com.bestgroup.business.handlers.util;

import java.util.Objects;
import java.util.function.Function;

import com.bestgroup.core.DomainEntity;
import com.bestgroup.core.Handler;
import com.bestgroup.core.Payload;
import com.bestgroup.core.exception.HandlerException;

public class ValidateString extends ValidationHandler<String> {

	protected int maxLength = Integer.MAX_VALUE;
	protected int minLength = Integer.MIN_VALUE;
	protected boolean trim = true;

	public <T extends DomainEntity> ValidateString(Handler next, Function<DomainEntity, ? extends T> typeConverter,
			Function<T, String> getter, String fieldName) {
		super(next, typeConverter, getter, fieldName);
	}

	@Override
	public Payload validate(Payload payload) throws HandlerException {

		payload = super.validate(payload);

		String value = Objects.requireNonNullElse(this.getter.apply(payload.getDomainEntity()), "");

		if (this.trim) {
			value = value.trim();
		}

		if (value.length() < this.minLength || value.length() > this.maxLength) {
			payload.getErrors().putIfAbsent(this.fieldName, this.getMessageForInvalidLength());
		}

		return payload;
	}

	public String getMessageForInvalidLength() {
		return String.format("The field '%s' must be between %d and %d characters.", this.fieldName, this.minLength, this.maxLength);
	}
}
