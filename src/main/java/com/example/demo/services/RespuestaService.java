package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.RespuestaModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.RespuestaRepository;


@Service
public class RespuestaService {

	 @Autowired
	    RespuestaRepository respuestaRepository;
	    
	public ArrayList<RespuestaModel> obtenerRespuesta() {
		return (ArrayList<RespuestaModel>) respuestaRepository.findAll();
	}

	public RespuestaModel guardarRespuesta(RespuestaModel respuesta){
        return respuestaRepository.save(respuesta);
    }

    public Optional<RespuestaModel> obtenerPorId(Long id){
        return respuestaRepository.findById(id);
    }

    /*
    public ArrayList<RespuestaModel>  obtenerPorPrioridad(Integer prioridad) {
        return respuestaRepository.findByPrioridad(prioridad);
    }*/

    public boolean eliminarRespuesta(Long id) {
        try{
           respuestaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

	

}
