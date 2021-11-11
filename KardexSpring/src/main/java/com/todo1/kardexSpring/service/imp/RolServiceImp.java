package com.todo1.kardexSpring.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.kardexSpring.model.Rol;
import com.todo1.kardexSpring.repository.IRolRepository;
import com.todo1.kardexSpring.service.IRolService;

@Service
public class RolServiceImp implements IRolService {

	@Autowired
	private IRolRepository repo;

	@Override
	@Transactional
	public Rol saveRol(Rol rol) {
		// TODO Auto-generated method stub
		return repo.save(rol);
	}

}
