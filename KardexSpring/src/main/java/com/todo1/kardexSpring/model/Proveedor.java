package com.todo1.kardexSpring.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.todo1.kardexSpring.model.embeddedId.ProveedorID;

@Entity
public class Proveedor {

	@EmbeddedId
	private ProveedorID id;
	
	@Column(nullable = false)
	private String nombre;

	//GETTERS
	public ProveedorID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	//SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "[" + id + "]";
	}

	
	
}
