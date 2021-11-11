package com.todo1.kardexSpring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.todo1.kardexSpring.model.embeddedId.ProveedorProductoID;

@Entity
public class Proveedor_Producto {

	@EmbeddedId
	private ProveedorProductoID id;

	@MapsId("provedorId")
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "PROVEEDOR_ID", referencedColumnName = "ID"),
			@JoinColumn(name = "PROVEEDOR_NIT", referencedColumnName = "NIT") })
	private Proveedor proveedor;
	

	@MapsId("productoId")
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID"),
			@JoinColumn(name = "PRODUCTO_CATEGORIA_ID", referencedColumnName = "CATEGORIA_ID") })
	private Producto producto;



	public ProveedorProductoID getId() {
		return id;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}

	public Producto getProducto() {
		return producto;
	}


	
	public void setId(ProveedorProductoID id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "[" + proveedor + ", producto=" + producto + "]";
	}
	

	
}
