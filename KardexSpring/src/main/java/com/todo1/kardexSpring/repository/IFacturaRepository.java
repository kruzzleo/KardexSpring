package com.todo1.kardexSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.kardexSpring.model.Factura;
import com.todo1.kardexSpring.model.embeddedId.FacturaID;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura, FacturaID>{

}
