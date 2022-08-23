package com.wipro.rolebasedjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.rolebasedjwt.model.DAOUser;


@Repository
public interface UserRepository extends JpaRepository<DAOUser, Integer>{
	DAOUser findByUsername(String username);
}