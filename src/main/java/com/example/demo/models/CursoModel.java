package com.example.demo.models;


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
@Table(name = "curso")
public class CursoModel {

	   @Id
	    @Column(nullable = false, updatable = false)
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idCat;

	    public Long getIdCat() {
		return idCat;
	}


	public String getNombreCat() {
		return nombreCat;
	}

	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}

	public String getDescripcionCat() {
		return descripcionCat;
	}

	public void setDescripcionCat(String descripcionCat) {
		this.descripcionCat = descripcionCat;
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

		@Column(nullable = false, length = 40)
	    private String nombreCat;

	    @Column(nullable = false)
	    private String descripcionCat;

	    @CreatedDate
	    @Column(nullable = false, updatable = false)
	    private OffsetDateTime dateCreated;

	    @LastModifiedDate
	    @Column(nullable = false)
	    private OffsetDateTime lastUpdated;
    }

   

