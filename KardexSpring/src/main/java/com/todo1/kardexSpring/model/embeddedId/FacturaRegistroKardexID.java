package com.todo1.kardexSpring.model.embeddedId;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class FacturaRegistroKardexID implements Serializable {

	@AttributeOverrides({
		@AttributeOverride(name = "kardexId.provedorId.id", column = @Column(name = "KARDEX_PROVEEDOR_ID")),
		@AttributeOverride(name = "kardexId.provedorId.nit", column = @Column(name = "KARDEX_PROVEEDOR_NIT")), 
		@AttributeOverride(name = "kardexId.productoId.id", column = @Column(name = "KARDEX_PRODUCTO_ID")),
		@AttributeOverride(name = "kardexId.productoId.categoriaId", column = @Column(name = "KARDEX_CATEGORIA_ID"))	
		
	})
	private KardexID kardexId;
	
		
	@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name = "FACTURA_ID")),
		@AttributeOverride(name = "usuario", column = @Column(name = "FACTURA_USUARIO_ID"))		
	})
	private FacturaID facturaId;

}
