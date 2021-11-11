package com.todo1.kardexSpring.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.kardexSpring.model.Factura_Registro_Kardex;
import com.todo1.kardexSpring.repository.IFactura_Registro_KardexRepository;
import com.todo1.kardexSpring.service.IFactura_Registro_KardexService;

@Service
@Transactional
public class Factura_Registro_KardexServiceImp implements IFactura_Registro_KardexService{

	@Autowired
	private IFactura_Registro_KardexRepository  repo;
	
	
	@Override
	public Factura_Registro_Kardex saveFacturaRegistroKardex(Factura_Registro_Kardex a) {
		return repo.save(a);
	}

}
