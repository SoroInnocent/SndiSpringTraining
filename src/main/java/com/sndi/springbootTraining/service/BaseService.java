package com.sndi.springbootTraining.service;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sndi.springbootTraining.entities.BaseEntity;

@Service
public abstract class BaseService<E extends BaseEntity> {

	protected abstract JpaRepository<E, Long> getRepository();

	protected abstract E getNewInstance();

	protected abstract E setData(E entity, Object dto);

	public E ajouter(Object dto) {
		E entity = this.getNewInstance();
		setData(entity, dto);
		this.getRepository().save(entity);

		return entity;
	}

	public Map<String, Object> supprimer(Long id) {
		boolean success = false;
		String message = "";

		try {
			E entity = this.getRepository().findById(id).get();
			this.getRepository().delete(entity);
			success = true;
		}
		catch (Exception e) {
			message = e.getMessage();
		}

		return Map.of(
				"success", success,
				"message", message
			);
	}

	public E modifier(Long id, Object dto) {
		E entity = null;

		try {
			entity = this.getRepository().findById(id).get();
			setData(entity, dto);
			this.getRepository().save(entity);
		}
		catch (Exception e) {
		}

		return entity;
	}
}
