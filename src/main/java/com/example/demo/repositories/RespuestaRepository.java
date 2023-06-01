package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.RespuestaModel;


public interface RespuestaRepository extends JpaRepository<RespuestaModel, Long>{

}
