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


@Entity
@Table(name = "respuesta")
public class RespuestaModel {

	@Id
	    @Column(nullable = false, updatable = false)
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idPost;

	    @Column(nullable = false)
	    private String contenidoPost;

	    @Column(nullable = false)
	    private LocalDate fechaPost;

	    @Column(nullable = false, length = 40)
	    private String tituloPost;

	    @Column(nullable = false)
	    private String autor;

	    @Column(nullable = false)
	    private Boolean solucion;

	    @CreatedDate
	    @Column(nullable = false, updatable = false)
	    private OffsetDateTime dateCreated;

	    @LastModifiedDate
	    @Column(nullable = false)
	    private OffsetDateTime lastUpdated;

	    public Long getIdPost() {
			return idPost;
		}

		public String getContenidoPost() {
			return contenidoPost;
		}

		public void setContenidoPost(String contenidoPost) {
			this.contenidoPost = contenidoPost;
		}

		public LocalDate getFechaPost() {
			return fechaPost;
		}

		public void setFechaPost(LocalDate fechaPost) {
			this.fechaPost = fechaPost;
		}

		public String getTituloPost() {
			return tituloPost;
		}

		public void setTituloPost(String tituloPost) {
			this.tituloPost = tituloPost;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public Boolean getSolucion() {
			return solucion;
		}

		public void setSolucion(Boolean solucion) {
			this.solucion = solucion;
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
}
