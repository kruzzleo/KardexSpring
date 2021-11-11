package com.todo1.kardexSpring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo1.kardexSpring.model.Usuario;
import com.todo1.kardexSpring.service.IUsuarioService;

@Controller
@RequestMapping("/private")
public class PrivateController {

	private IUsuarioService usuarioService;
	
	@RequestMapping("/index")
	public String privateHome(Authentication auth, HttpSession session) {
		String username = auth.getName();
		
		System.out.println(username);
		for(GrantedAuthority a : auth.getAuthorities()) {
			System.out.println(a.getAuthority());
		}
		
		System.out.println("*****");
		
		if(session.getAttribute("usuario") == null) {
			//Usuario usuario = usuarioService.findByNit(username);
			Usuario usuario = new Usuario();

			usuario.setPassword(null);
			session.setAttribute("usuario", usuario);
		}
		return "privateHome";
		
	}
}
