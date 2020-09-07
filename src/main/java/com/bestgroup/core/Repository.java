package com.bestgroup.core;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.bestgroup.core.exception.RepositoryException;

public class Repository<T extends DomainEntity> {

	protected EntityManager entityManager;
	protected Class<T> type;

	public Repository(EntityManager entityManager, Class<T> type) {
		this.entityManager = entityManager;
		this.type = type;
	}

	public T find(Long id) throws RepositoryException {

		try {
			return this.entityManager.find(this.type, id);
		} catch (Exception exception) {
			throw new RepositoryException(exception);
		}
	}

	public T save(T entity) throws RepositoryException {

		try {
			this.entityManager.persist(entity);
			return entity;
		} catch (Exception exception) {
			throw new RepositoryException(exception);
		}
	}

	public T remove(T entity) throws RepositoryException {

		try {

			T removed = Objects.requireNonNull(this.find(entity.getId()),
					"The entity cannot be removed because it does not exist");
			this.entityManager.remove(removed);
			return removed;

		} catch (Exception exception) {
			throw new RepositoryException(exception);
		}
	}

	public T edit(T entity) throws RepositoryException {

		try {
			Objects.requireNonNull(this.find(entity.getId()), "The entity cannot be updated because it does not exist");
			return this.entityManager.merge(entity);
		} catch (Exception exception) {
			throw new RepositoryException(exception);
		}
	}

	public List<T> getAll() throws RepositoryException {

		try {
			CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<T> query = criteriaBuilder.createQuery(this.type);
			Root<T> root = query.from(this.type);
			query = query.select(root);
			TypedQuery<T> getAll = this.entityManager.createQuery(query);
			return getAll.getResultList();
		} catch (Exception exception) {
			throw new RepositoryException(exception);
		}
	}

}
