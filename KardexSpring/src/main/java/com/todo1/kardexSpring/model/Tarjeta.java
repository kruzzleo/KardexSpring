package com.todo1.kardexSpring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.todo1.kardexSpring.model.embeddedId.TarjetaID;

@Entity
public class Tarjeta {

	@EmbeddedId
	private TarjetaID id;
	
}
