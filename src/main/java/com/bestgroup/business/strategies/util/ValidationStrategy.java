package com.bestgroup.business.strategies.util;

import java.util.function.Function;

import com.bestgroup.core.DomainEntity;
import com.bestgroup.core.Strategy;

public abstract class ValidationStrategy<V> implements Strategy {

	protected String fieldName;
	protected Function<DomainEntity, V> getter;

	public <T extends DomainEntity> ValidationStrategy(Function<DomainEntity, ? extends T> typeConverter,
			Function<T, V> getter, String fieldName) {
		this.fieldName = fieldName;
		this.getter = entity -> getter.apply(typeConverter.apply(entity));
	}
}
