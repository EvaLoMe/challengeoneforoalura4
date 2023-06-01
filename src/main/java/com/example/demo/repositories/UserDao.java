package com.example.demo.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UsuarioModel;



@Repository
public interface UserDao extends CrudRepository<UsuarioModel, Integer> {
	
	UsuarioModel findBynombre(String username);
	
}