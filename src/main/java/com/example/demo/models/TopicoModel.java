package com.example.demo.models;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity


public class TopicoModel {

	@Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false, length = 40, unique=true)
    private String titulo;

    @Column(nullable = false, unique=true)
    private String mensaje;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false, length = 20)
    private String statusTopico;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false, length = 40)
    private String curso;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;
	

    public Long getId() {
		return id;
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

	public OffsetDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(OffsetDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public OffsetDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(OffsetDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	public void updateTopico(TopicoDTO topico) {
		
		if(topico.getTitulo()!=null)
	    this.titulo=topico.getTitulo();
		if(topico.getMensaje()!=null)
		this.mensaje=topico.getMensaje();
		if(topico.getFechaCreacion()!=null)
		this.fechaCreacion=topico.getFechaCreacion();
		if(topico.getStatusTopico()!=null)
		this.statusTopico=topico.getStatusTopico();
		if(topico.getCurso()!=null)
		this.curso=topico.getCurso();
		
	}
}
