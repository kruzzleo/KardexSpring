package com.todo1.kardexSpring.service;

import java.util.Optional;

import com.todo1.kardexSpring.model.Usuario;

public interface IUsuarioService {

	Optional<Usuario> findByNit(String nit);
	
	Usuario saveUsuario(Usuario usuario);

}
