package com.example.demo.services;
import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.TopicoDTO;
import com.example.demo.models.TopicoModel;

import com.example.demo.repositories.TopicoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    TopicoRepository topicoRepository;
    
    public ArrayList<TopicoModel> obtenerTopico(){
        return (ArrayList<TopicoModel>) topicoRepository.findAll();
    }

    public TopicoModel guardarTopico(TopicoModel topico){
        return topicoRepository.save(topico);
    }

    public Optional<TopicoModel> obtenerPorId(Long id){
        return topicoRepository.findById(id);
    }

/*
    public ArrayList<TopicoModel>  obtenerPorPrioridad(Integer prioridad) {
        return topicoRepository.findByPrioridad(prioridad);
    }
*/
    public boolean eliminarTopico(Long id) {
        try{
            topicoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

	public TopicoModel actualizarTopico(TopicoDTO topico) {
		TopicoModel topicoActualizable=topicoRepository.findByTitulo(topico.getTitulo());
		topicoActualizable.updateTopico(topico);
		topicoRepository.save(topicoActualizable);
		return topicoActualizable;
	}



    
}