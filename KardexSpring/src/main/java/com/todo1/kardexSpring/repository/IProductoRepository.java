package com.todo1.kardexSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.kardexSpring.model.Producto;
import com.todo1.kardexSpring.model.embeddedId.ProductoID;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, ProductoID> {

}
