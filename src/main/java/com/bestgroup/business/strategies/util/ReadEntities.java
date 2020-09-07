package com.bestgroup.business.strategies.util;

import java.util.List;

import javax.persistence.TypedQuery;

import com.bestgroup.core.DomainEntity;
import com.bestgroup.core.Pagination;
import com.bestgroup.core.Payload;
import com.bestgroup.core.exception.StrategyException;

public class ReadEntities extends EntityManagerStrategy {

	@Override
	public Payload onPayload(Payload payload) throws StrategyException {
		payload = super.onPayload(payload);

		if (payload.getReceivedEntity().getId() != null) {
			DomainEntity entityFound = this.getOne(payload.getReceivedEntity());
			payload.getEntities().add(entityFound);
		} else {
			List<? extends DomainEntity> entitiesFound = this.getSeveral(payload.getReceivedEntity(), payload.getPagination());
			payload.getEntities().addAll(entitiesFound);
		}

		return payload;
	}

	public DomainEntity getOne(DomainEntity entity) {
		return this.entityManager.find(entity.getClass(), entity.getId());
	}

	public List<? extends DomainEntity> getSeveral(DomainEntity entity, Pagination pagination) {

		String jpql = String.format("SELECT e FROM %s e WHERE e.deletedAt IS NULL", entity.getClass().getSimpleName());

		TypedQuery<? extends DomainEntity> query = this.entityManager.createQuery(jpql, entity.getClass());

		if (pagination.getPageSize() > 0) {
			System.out.println(pagination);

			query.setFirstResult((pagination.getPageNumber() - 1) * pagination.getPageSize());
			query.setMaxResults(pagination.getPageSize());
		}

		System.out.println(pagination);

		return query.getResultList();
	}
}
