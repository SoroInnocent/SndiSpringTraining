package com.sndi.springbootTraining.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sndi.springbootTraining.entities.BaseEntity;
import com.sndi.springbootTraining.service.BaseService;

@RestController
public abstract class BaseController<E extends BaseEntity, D extends Object, S extends BaseService<E>> {

	protected abstract S getService();

	@PostMapping("/ajouter")
	public E ajouter(@RequestBody D dto) {
		return getService().ajouter(dto);
	}

	@GetMapping("/supprimer")
	public Map<String, Object> supprimer(@RequestParam Long id) {
		return getService().supprimer(id);
	}

	@PostMapping("/modifier")
	public E modifier(@RequestParam Long id, @RequestBody D dto) {
		return getService().modifier(id, dto);
	}
}
