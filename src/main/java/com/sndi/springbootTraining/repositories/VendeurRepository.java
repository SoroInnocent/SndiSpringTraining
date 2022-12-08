package com.sndi.springbootTraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sndi.springbootTraining.entities.Vendeur;

public interface VendeurRepository extends JpaRepository<Vendeur, Long> {

}
