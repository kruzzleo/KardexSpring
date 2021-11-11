package com.todo1.kardexSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.kardexSpring.model.Factura_Registro_Kardex;
import com.todo1.kardexSpring.model.embeddedId.FacturaRegistroKardexID;

@Repository
public interface IFactura_Registro_KardexRepository extends JpaRepository<Factura_Registro_Kardex, FacturaRegistroKardexID>{

}
