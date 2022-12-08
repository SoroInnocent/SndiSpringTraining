package com.sndi.springbootTraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sndi.springbootTraining.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
