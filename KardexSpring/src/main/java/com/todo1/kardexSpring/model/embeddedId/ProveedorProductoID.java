package com.todo1.kardexSpring.model.embeddedId;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ProveedorProductoID implements Serializable {

    @AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "PROVEEDOR_ID")),
        @AttributeOverride(name = "nit", column = @Column(name = "PROVEEDOR_NIT"))
      })
	private ProveedorID provedorId;
	
    @AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "PRODUCTO_ID")),
        @AttributeOverride(name = "categoriaId", column = @Column(name = "PRODUCTO_CATEGORIA_ID"))
      })
	private ProductoID productoId;
	

	public ProveedorID getProvedorId() {
		return provedorId;
	}

	public ProductoID getProductoId() {
		return productoId;
	}

	
	
	public void setProvedorId(ProveedorID provedorId) {
		this.provedorId = provedorId;
	}

	public void setProductoId(ProductoID productoId) {
		this.productoId = productoId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		ProveedorProductoID ppID = (ProveedorProductoID) obj;
		return this.productoId.equals(ppID.productoId) && this.provedorId.equals(ppID.provedorId);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.productoId == null) ? 0 : this.productoId.hashCode());
		result = prime * result + ((this.provedorId == null) ? 0 : this.provedorId.hashCode());
		return result;
	}
	
	
	


	
}
