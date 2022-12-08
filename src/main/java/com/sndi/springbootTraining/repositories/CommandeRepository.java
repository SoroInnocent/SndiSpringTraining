package com.sndi.springbootTraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sndi.springbootTraining.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
