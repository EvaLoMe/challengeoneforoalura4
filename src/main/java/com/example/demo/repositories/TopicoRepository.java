package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.TopicoModel;
import com.example.demo.models.UsuarioModel;

public interface TopicoRepository extends JpaRepository<TopicoModel, Long> {
	public abstract TopicoModel findByTitulo(String titulo);
}
