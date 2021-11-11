package com.todo1.kardexSpring.model;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.todo1.kardexSpring.model.embeddedId.FacturaRegistroKardexID;

@Entity
public class Factura_Registro_Kardex {

	@EmbeddedId
	private FacturaRegistroKardexID facturaRegistroKardexID;

	@MapsId("kardexId")
	@OneToOne
	@JoinColumns({ @JoinColumn(name = "KARDEX_PROVEEDOR_ID", referencedColumnName = "PROVEEDOR_ID"),
			@JoinColumn(name = "KARDEX_PROVEEDOR_NIT", referencedColumnName = "PROVEEDOR_NIT"),
			@JoinColumn(name = "KARDEX_PRODUCTO_ID", referencedColumnName = "PRODUCTO_ID"),
			@JoinColumn(name = "KARDEX_CATEGORIA_ID", referencedColumnName = "CATEGORIA_ID") })
	private Kardex kardex;

	@OneToOne
	@JoinColumns({ @JoinColumn(name = "FACTURA_ID", referencedColumnName = "ID"),
			@JoinColumn(name = "FACTURA_USUARIO_ID", referencedColumnName = "USUARIO_ID") })
	private Factura factura;

	private int cantidad;
	private int valor;
	private String descripcion;
	private String tipo;

	public Factura_Registro_Kardex(Kardex kardex, Factura factura, int cantidad, int valor, String descripcion,
			String tipo) {
		super();
		this.kardex = kardex;
		//this.factura = factura;
		this.cantidad = cantidad;
		this.valor = valor;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}

	public FacturaRegistroKardexID getFacturaRegistroKardexID() {
		return facturaRegistroKardexID;
	}

	public void setFacturaRegistroKardexID(FacturaRegistroKardexID facturaRegistroKardexID) {
		this.facturaRegistroKardexID = facturaRegistroKardexID;
	}

//	public Factura getFactura() {
//		return factura;
//	}
//
//	public void setFactura(Factura factura) {
//		this.factura = factura;
//	}

	public Factura_Registro_Kardex() {
		// TODO Auto-generated constructor stub
	}

	public Kardex getKardex() {
		return kardex;
	}

	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
