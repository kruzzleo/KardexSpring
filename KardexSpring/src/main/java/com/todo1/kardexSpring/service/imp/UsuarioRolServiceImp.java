package com.todo1.kardexSpring.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.kardexSpring.model.Usuario_Rol;
import com.todo1.kardexSpring.repository.IUsuarioRolRepository;
import com.todo1.kardexSpring.service.IUsuarioRolService;

@Service
public class UsuarioRolServiceImp implements IUsuarioRolService {

	@Autowired
	private IUsuarioRolRepository repo;

	@Override
	@Transactional
	public Usuario_Rol saveUsuarioRol(Usuario_Rol a) {
		// TODO Auto-generated method stub
		return repo.save(a);
	}

}
