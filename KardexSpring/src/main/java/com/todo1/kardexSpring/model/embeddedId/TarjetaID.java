package com.todo1.kardexSpring.model.embeddedId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TarjetaID implements Serializable {

	@Column(unique = true)
	private Long numtarjeta;
	private String usuario_nit;
}
