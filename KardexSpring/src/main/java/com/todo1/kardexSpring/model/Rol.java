package com.todo1.kardexSpring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.todo1.kardexSpring.model.enums.RolNombre;

@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private RolNombre nombre;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Usuario_Rol> usuarios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RolNombre getNombre() {
		return nombre;
	}

	public void setNombre(RolNombre nombre) {
		this.nombre = nombre;
	}

	public List<Usuario_Rol> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario_Rol> usuarios) {
		this.usuarios = usuarios;
	}

	public Rol(RolNombre nombre, List<Usuario_Rol> usuarios) {
		super();	
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	public Rol() {
		// TODO Auto-generated constructor stub
	}

}
