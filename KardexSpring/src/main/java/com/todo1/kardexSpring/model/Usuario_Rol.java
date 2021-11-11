package com.todo1.kardexSpring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.todo1.kardexSpring.model.embeddedId.Usuario_RolID;

@Entity
public class Usuario_Rol {

	@EmbeddedId
	private Usuario_RolID id;
	
	@MapsId("usuario_nit")
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
	private Usuario usuario;
	
	@MapsId("rol_id")
	@ManyToOne
	@JoinColumn(name = "ROL_ID", referencedColumnName = "ID")
	private Rol rol;

	public Usuario_RolID getId() {
		return id;
	}

	public void setId(Usuario_RolID id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario_Rol(Usuario_RolID id, Usuario usuario, Rol rol) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.rol = rol;
	}

	public Usuario_Rol() {
		// TODO Auto-generated constructor stub
	}
	
	
}
