package com.sndi.springbootTraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sndi.springbootTraining.entities.Acheteur;

public interface AcheteurRepository extends JpaRepository<Acheteur, Long>{

}
