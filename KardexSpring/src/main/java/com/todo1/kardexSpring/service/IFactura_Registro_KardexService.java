package com.todo1.kardexSpring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.todo1.kardexSpring.model.Factura_Registro_Kardex;
import com.todo1.kardexSpring.model.embeddedId.FacturaRegistroKardexID;


public interface IFactura_Registro_KardexService {

	Factura_Registro_Kardex saveFacturaRegistroKardex(Factura_Registro_Kardex a);

}
