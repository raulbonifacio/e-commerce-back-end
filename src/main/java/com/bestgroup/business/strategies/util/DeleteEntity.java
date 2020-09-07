package com.bestgroup.business.strategies.util;

import com.bestgroup.core.Payload;
import com.bestgroup.core.exception.StrategyException;

import java.time.LocalDateTime;

import com.bestgroup.core.DomainEntity;

public class DeleteEntity extends EntityManagerStrategy {

	@Override
	public Payload onPayload(Payload payload) throws StrategyException {

		payload = super.onPayload(payload);

		DomainEntity entity = payload.getReceivedEntity();

		entity.setDeletedAt(LocalDateTime.now());

		this.entityManager.merge(entity);

		payload.getEntities().add(entity);

		return payload;
	}

}
