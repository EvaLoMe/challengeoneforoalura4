package com.example.demo.models;

import java.time.LocalDate;

public class TopicoDTO {

	private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fechaCreacion;
    private String statusTopico;
    private String autor;
    private String curso;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getStatusTopico() {
		return statusTopico;
	}
	public void setStatusTopico(String statusTopico) {
		this.statusTopico = statusTopico;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

}
