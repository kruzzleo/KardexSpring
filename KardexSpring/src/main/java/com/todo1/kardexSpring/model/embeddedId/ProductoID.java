package com.todo1.kardexSpring.model.embeddedId;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class ProductoID implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "CATEGORIA_ID")
	private Long categoriaId;
	
	public Long getId() {
		return id;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", categoriaId=" + categoriaId + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		ProductoID pID = (ProductoID) obj;
		return this.id == pID.id &&
				pID.categoriaId == this.categoriaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id.hashCode();
		result = prime * result + this.id.hashCode();
		return result;
	}
	
	
	
	
	
	
	
}
