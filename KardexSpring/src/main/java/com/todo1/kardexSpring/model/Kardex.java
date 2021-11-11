package com.todo1.kardexSpring.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.todo1.kardexSpring.model.embeddedId.KardexID;

@Entity
public class Kardex {

	@EmbeddedId
	private KardexID id;

	@MapsId("kardexId")
	@OneToOne
	@JoinColumns({ @JoinColumn(name = "PROVEEDOR_ID", referencedColumnName = "PROVEEDOR_ID"),
			@JoinColumn(name = "PROVEEDOR_NIT", referencedColumnName = "PROVEEDOR_NIT"),
			@JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "PRODUCTO_ID"),
			@JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "PRODUCTO_CATEGORIA_ID") })
	private Proveedor_Producto proveedor_producto;

	@Column(nullable = false)
	private long unidades_min;

	@Column(nullable = false)
	private long unidades_max;

	@Column(name = "UNIDADESACTUALES", nullable = false)
	private long unidadesActuales;

	@Column(name = "COSTOUNITARIO", nullable = false)
	private long costoUnitario;

	// GETTERS
	public KardexID getId() {
		return id;
	}

	public Proveedor_Producto getProveedor_producto() {
		return proveedor_producto;
	}

	public long getUnidades_min() {
		return unidades_min;
	}

	public long getUnidades_max() {
		return unidades_max;
	}

	public long getUnidadesActuales() {
		return unidadesActuales;
	}

	public long getCostoUnitario() {
		return costoUnitario;
	}

	public void setId(KardexID id) {
		this.id = id;
	}

	public void setProveedor_producto(Proveedor_Producto proveedor_producto) {
		this.proveedor_producto = proveedor_producto;
	}

	public void setUnidades_min(long unidades_min) {
		this.unidades_min = unidades_min;
	}

	public void setUnidades_max(long unidades_max) {
		this.unidades_max = unidades_max;
	}

	public void setUnidadesActuales(long unidadesActuales) {
		this.unidadesActuales = unidadesActuales;
	}

	public void setCostoUnitario(long costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	// SETTERS

	public Kardex(KardexID id, Proveedor_Producto proveedor_producto, Long unidades_min, Long unidades_max,
			Long unidadesActuales, Long costoUnitario) {
		super();
		this.id = id;
		this.proveedor_producto = proveedor_producto;
		this.unidades_min = unidades_min;
		this.unidades_max = unidades_max;
		this.unidadesActuales = unidadesActuales;
		this.costoUnitario = costoUnitario;
	}

	public Kardex() {
	}

	@Override
	public String toString() {
		return "Kardex [id=" + proveedor_producto + ", unidades_min=" + unidades_min + ", unidades_max=" + unidades_max
				+ ", unidadesActuales=" + unidadesActuales + ", costoUnitario=" + costoUnitario + "]";
	}

}
