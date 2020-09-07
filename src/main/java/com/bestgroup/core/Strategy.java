package com.bestgroup.core;

import com.bestgroup.core.exception.StrategyException;

public interface Strategy {

	public default Payload onPayload(Payload payload) throws StrategyException {
		return payload;
	}
}
