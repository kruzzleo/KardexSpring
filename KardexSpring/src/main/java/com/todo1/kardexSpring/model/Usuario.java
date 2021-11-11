package com.todo1.kardexSpring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String nit;
	private String password;	
	@Column(name = "ISACTIVE")
	private int isActive;
	
	@OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
	private List<Usuario_Rol> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public List<Usuario_Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Usuario_Rol> roles) {
		this.roles = roles;
	}



	public Usuario( String nit, String password, int isActive, List<Usuario_Rol> roles) {
		super();
		this.nit = nit;
		this.password = password;
		this.isActive = isActive;
		this.roles = roles;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
}
