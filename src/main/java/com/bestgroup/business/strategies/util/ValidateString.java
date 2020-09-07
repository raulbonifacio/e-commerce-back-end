package com.bestgroup.business.strategies.util;

import java.util.Objects;
import java.util.function.Function;

import com.bestgroup.core.DomainEntity;
import com.bestgroup.core.Payload;
import com.bestgroup.core.exception.StrategyException;

public class ValidateString extends ValidationStrategy<String> {

	protected int maxLength = Integer.MAX_VALUE;
	protected int minLength = Integer.MIN_VALUE;
	protected boolean trim = true;

	public <T extends DomainEntity> ValidateString(Function<DomainEntity, ? extends T> typeConverter,
			Function<T, String> getter, String fieldName) {
		super(typeConverter, getter, fieldName);
	}

	@Override
	public Payload onPayload(Payload payload) throws StrategyException {

		payload = super.onPayload(payload);

		String value = Objects.requireNonNullElse(this.getter.apply(payload.getEntity()), "");

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
