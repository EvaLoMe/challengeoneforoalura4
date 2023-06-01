package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.CursoModel;
import com.example.demo.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @GetMapping()
    public ArrayList<CursoModel> obtenercurso(){
        return cursoService.obtenerCurso();
    }

    @PostMapping()
    public CursoModel guardarCurso(@RequestBody CursoModel curso){
        return this.cursoService.guardarCurso(curso);
    }

    @GetMapping( path = "/{id}")
    public Optional<CursoModel> obtenerCursoPorId(@PathVariable("id") Long id) {
        return this.cursoService.obtenerPorId(id);
    }
    /*
    @GetMapping("/query")
    public ArrayList<CursoModel> obtenerCursoPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.cursoService.obtenerPorPrioridad(prioridad);
    }*/

    @DeleteMapping( path = "/delete/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
    	//usuario
    	//permisos
    	//si permisos = "BORRAR"
        boolean ok = this.cursoService.eliminarCurso(id);
        if (ok){
            return "Se eliminó el curso con id " + id;
        }else{
            return "No pudo eliminar el curso con id" + id;
        }
    }
}

