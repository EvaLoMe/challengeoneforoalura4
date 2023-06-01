package com.example.demo.controllers;
import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.TopicoDTO;
import com.example.demo.models.TopicoModel;

import com.example.demo.services.TopicoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    TopicoService topicoService;

    @GetMapping()
    public ArrayList<TopicoModel> obtenerTopico(){
        return topicoService.obtenerTopico();
    }

    @PostMapping()
    public TopicoModel guardarTopico(@RequestBody TopicoModel topico){
    	System.out.println("Topico: "+topico.getAutor()+" "+topico.getCurso()+"<++++++++");
        return this.topicoService.guardarTopico(topico);
    }

    @GetMapping( path = "/{id}")
    public Optional<TopicoModel> obtenerTopicoPorId(@PathVariable("id") Long id) {
        return this.topicoService.obtenerPorId(id);
    }

    @PutMapping()
    public TopicoModel actualizarTopico(@RequestBody TopicoDTO topico){
    	System.out.println("Topico: "+topico.getAutor()+" "+topico.getCurso()+"<+++ actualizando Topico");
        return this.topicoService.actualizarTopico(topico);
    }
    /*@GetMapping("/query")
    public ArrayList<TopicoModel> obtenerTopicoPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.topicoService.obtenerPorPrioridad(prioridad);
    }*/

    @DeleteMapping( path = "/delete/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.topicoService.eliminarTopico(id);
        if (ok){
            return "Se eliminó el topico con id " + id;
        }else{
            return "No pudo eliminar el topico con id" + id;
        }
    }

}