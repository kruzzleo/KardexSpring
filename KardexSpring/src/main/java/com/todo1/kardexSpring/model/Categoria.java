package com.todo1.kardexSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(schema = "TODO1", name = "CATEGORIA")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	//SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
