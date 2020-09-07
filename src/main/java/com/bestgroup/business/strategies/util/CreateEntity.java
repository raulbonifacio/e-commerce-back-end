package com.bestgroup.business.strategies.util;

import java.time.LocalDateTime;

import com.bestgroup.core.DomainEntity;
import com.bestgroup.core.Payload;
import com.bestgroup.core.exception.StrategyException;

public class CreateEntity extends EntityManagerStrategy {

	@Override
	public Payload onPayload(Payload payload) throws StrategyException {

		payload = super.onPayload(payload);

		DomainEntity entity = payload.getReceivedEntity();

		entity.setCreateAt(LocalDateTime.now());
		
		this.entityManager.persist(entity);

		payload.getEntities().add(entity);

		return payload;
	}

}
