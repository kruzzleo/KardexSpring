package com.todo1.kardexSpring.model.embeddedId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import com.todo1.kardexSpring.model.Usuario;

@Embeddable
public class FacturaID implements Serializable {

	private long id;
	
	private long usuario;

	public FacturaID(long id, long usuario) {
		super();
		this.id = id;
		this.usuario = usuario;
	}

	public FacturaID() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

}
