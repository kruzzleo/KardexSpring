package com.todo1.kardexSpring.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.kardexSpring.model.Factura;
import com.todo1.kardexSpring.repository.IFacturaRepository;
import com.todo1.kardexSpring.service.IFacturaService;

@Service
@Transactional
public class FacturaServiceImp implements IFacturaService{

	@Autowired
	private IFacturaRepository repo;
	
	@Override
	public Factura saveFactura(Factura f) {
		return repo.save(f);
	}

}
