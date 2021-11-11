package com.todo1.kardexSpring.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.kardexSpring.model.Usuario;
import com.todo1.kardexSpring.repository.IUsuarioRepository;
import com.todo1.kardexSpring.service.IUsuarioService;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private BCryptPasswordEncoder passEnconder;

	@Autowired
	private IUsuarioRepository usuarioRepo;

	@Override
	public Optional<Usuario> findByNit(String nit) {
		return usuarioRepo.findByNit(nit);
	}

	@Transactional(readOnly = false)
	@Override
	public Usuario saveUsuario(Usuario usuario) {
		System.out.println(usuarioRepo.findByNit(usuario.getNit()));
		System.out.println(usuario.getNit().length());

		if (usuarioRepo.findByNit(usuario.getNit()).orElse(null) == null && usuario.getNit().length() != 0) {

			usuario.setPassword(passEnconder.encode(usuario.getPassword()));
			return usuarioRepo.save(usuario);
		}
		return null;
	}


}
