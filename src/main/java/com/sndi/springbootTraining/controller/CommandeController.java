package com.sndi.springbootTraining.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sndi.springbootTraining.dto.CommandeDto;
import com.sndi.springbootTraining.entities.Commande;
import com.sndi.springbootTraining.entities.StatutCommande;
import com.sndi.springbootTraining.service.CommandeService;

@RestController
@RequestMapping("/commande")
public class CommandeController  extends BaseController<Commande, CommandeDto, CommandeService> {

	private final CommandeService commandeService;

	public CommandeController(CommandeService commandeService) {
		this.commandeService = commandeService;
	}

	protected CommandeService getService() {
		return commandeService;
	}

	@PostMapping("/livrer")
	public Commande livrer(@RequestParam Long id, @RequestBody CommandeDto dto) {
		dto.statutCommande = StatutCommande.ACHETE;
		return commandeService.changerStatut(id, dto);
	}

	@PostMapping("/annuler")
	public Commande annuler(@RequestParam Long id, @RequestBody CommandeDto dto) {
		dto.statutCommande = StatutCommande.ANNULE;
		return commandeService.changerStatut(id, dto);
	}
}
