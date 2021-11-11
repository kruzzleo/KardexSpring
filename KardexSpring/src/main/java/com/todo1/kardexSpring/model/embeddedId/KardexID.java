package com.todo1.kardexSpring.model.embeddedId;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.todo1.kardexSpring.model.Proveedor_Producto;

@Embeddable
public class KardexID implements Serializable {

	@AttributeOverrides({ @AttributeOverride(name = "provedorId.id", column = @Column(name = "PROVEEDOR_ID")),
			@AttributeOverride(name = "provedorId.nit", column = @Column(name = "PROVEEDOR_NIT")),
			@AttributeOverride(name = "productoId.id", column = @Column(name = "PRODUCTO_ID")),
			@AttributeOverride(name = "productoId.categoriaId", column = @Column(name = "CATEGORIA_ID")) })
	private ProveedorProductoID kardexId;

	public KardexID init(long provedorId, String provedorNit, long productoId, long categoriaId) {
		ProveedorProductoID pp = new ProveedorProductoID();
		ProveedorID pvi = new ProveedorID();
		pvi.setId(provedorId);
		pvi.setNit(provedorNit);
		ProductoID pi = new ProductoID();
		pi.setId(productoId);
		pi.setCategoriaId(categoriaId);

		pp.setProductoId(pi);
		pp.setProvedorId(pvi);
		setKardexId(pp);
		return this;
	}

	public void setKardexId(ProveedorProductoID kardexId) {
		this.kardexId = kardexId;
	}
	
	public ProveedorProductoID getKardexId() {
		return kardexId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		KardexID kID = (KardexID) obj;
		return this.kardexId.equals(kID.kardexId);

		/*
		 * return (kID.kardexId.getProductoId().getId() ==
		 * this.kardexId.getProductoId().getId()) &&
		 * (kID.kardexId.getProductoId().getCategoriaId() ==
		 * this.kardexId.getProductoId().getCategoriaId()) &&
		 * (kID.kardexId.getProvedorId().getId() ==
		 * this.kardexId.getProvedorId().getId()) &&
		 * (kID.kardexId.getProvedorId().getNit() ==
		 * this.kardexId.getProvedorId().getNit() ||
		 * (this.kardexId.getProvedorId().getNit() != null &&
		 * this.kardexId.getProvedorId().getNit().equals(kID.kardexId.getProvedorId().
		 * getNit())));
		 */
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kardexId == null) ? 0 : kardexId.hashCode() + kardexId.hashCode());
		return result;
	}

}
