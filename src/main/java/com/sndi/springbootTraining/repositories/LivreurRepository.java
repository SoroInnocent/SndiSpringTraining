package com.sndi.springbootTraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sndi.springbootTraining.entities.Livreur;

public interface LivreurRepository extends JpaRepository<Livreur, Long> {

}
