package com.todo1.kardexSpring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.todo1.kardexSpring.model.Usuario;
import com.todo1.kardexSpring.service.IUsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioService usuarioRepo;

	@Override
	public UserDetails loadUserByUsername(String nit) throws UsernameNotFoundException {
		Usuario user = usuarioRepo.findByNit(nit)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no Encontrado " + nit));

		return UsuarioModel.build(user);

	}

}
