package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.CursoModel;
import com.example.demo.repositories.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	
	@Service
	public class CursoService {

	    @Autowired
	    CursoRepository cursoRepository;
	    
	    public ArrayList<CursoModel> obtenerCurso(){
	        return (ArrayList<CursoModel>) cursoRepository.findAll();
	    }

	    public CursoModel guardarCurso(CursoModel curso){
	        return cursoRepository.save(curso);
	    }

	    public Optional<CursoModel> obtenerPorId(Long id){
	        return cursoRepository.findById(id);
	    }

	    /*
	    public ArrayList<CursoModel>  obtenerPorPrioridad(Integer prioridad) {
	        return cursoRepository.findByPrioridad(prioridad);
	    }*/

	    public boolean eliminarCurso(Long id) {
	        try{
	            cursoRepository.deleteById(id);
	            return true;
	        }catch(Exception err){
	            return false;
	        }
	    }


}
