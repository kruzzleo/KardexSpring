package com.todo1.kardexSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.kardexSpring.model.Proveedor_Producto;
import com.todo1.kardexSpring.model.embeddedId.ProveedorProductoID;

@Repository
public interface IProveedor_ProductoRepository extends JpaRepository<Proveedor_Producto, ProveedorProductoID>{

}
