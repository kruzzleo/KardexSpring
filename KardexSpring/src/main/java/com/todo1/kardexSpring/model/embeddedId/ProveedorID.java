package com.todo1.kardexSpring.model.embeddedId;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class ProveedorID implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nit;
	
	public Long getId() {
		return id;
	}

	public String getNit() {
		return nit;
	}
	
	

	public void setId(Long id) {
		this.id = id;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nit=" + nit + "]";
	}




	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		ProveedorID pID = (ProveedorID) obj;
		return this.id == pID.id &&
				(pID.nit == this.nit ||
				(this.nit != null && this.nit.equals(pID.nit)));

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id.hashCode();
		result = prime * result + ((this.nit == null) ? 0 : this.nit.hashCode());
		return result;
	}
	
	
	
	
}
