package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.RespuestaModel;
import com.example.demo.services.RespuestaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/respuesta")
public class RespuestaController {
    @Autowired
    RespuestaService respuestaService;

    @GetMapping()
    public ArrayList<RespuestaModel> obtenerRespuesta(){
        return respuestaService.obtenerRespuesta();
    }

    @PostMapping()
    public RespuestaModel guardarRespuesta(@RequestBody RespuestaModel respuesta){
        return this.respuestaService.guardarRespuesta(respuesta);
    }

    @GetMapping( path = "/{id}")
    public Optional<RespuestaModel> obtenerRespuestaPorId(@PathVariable("id") Long id) {
        return this.respuestaService.obtenerPorId(id);
    }

    /*@GetMapping("/query")
    public ArrayList<RespuestaModel> obtenerRespuestaPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.respuestaService.obtenerPorPrioridad(prioridad);
    }*/

    @DeleteMapping( path = "/delete/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.respuestaService.eliminarRespuesta(id);
        if (ok){
            return "Se eliminó el post con id " + id;
        }else{
            return "No pudo eliminar el post con id" + id;
        }
    }



}
