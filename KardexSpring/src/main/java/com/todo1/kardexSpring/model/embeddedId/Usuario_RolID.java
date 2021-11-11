package com.todo1.kardexSpring.model.embeddedId;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Usuario_RolID implements Serializable {

	private long usuario_id;
	private long rol_id;

	public long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public long getRol_id() {
		return rol_id;
	}

	public void setRol_id(long rol_id) {
		this.rol_id = rol_id;
	}

	public Usuario_RolID(long usuario_id, long rol_id) {
		super();
		this.usuario_id = usuario_id;
		this.rol_id = rol_id;
	}

	public Usuario_RolID() {
		// TODO Auto-generated constructor stub
	}

}
