package com.todo1.kardexSpring.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.todo1.kardexSpring.model.embeddedId.ProductoID;

@Entity
@Table(schema = "TODO1", name = "PRODUCTO")
public class Producto {

	@EmbeddedId
	private ProductoID id;
	
	@Column(nullable = false)
	private String nombre;
	
	@MapsId("categoriaId")
	@ManyToOne
	@JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "ID")
	private Categoria categoria;

	public ProductoID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	//SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "[" + id + "]";
	}


	
}
