package com.todo1.kardexSpring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo1.kardexSpring.model.Usuario;
import com.todo1.kardexSpring.service.IUsuarioService;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private IUsuarioService usuarioService;

	// Despliega el formulario de logueo
	@GetMapping("/login")
	public String getLoginForm(Model model) {
		Usuario u = new Usuario();
		model.addAttribute("usuario", u);
		return "loginForm";
	}

	// Despliega el formulario de registro
	@GetMapping("/register")
	public String getRegisterForm(Model model) {
		Usuario u = new Usuario();
		model.addAttribute("usuario", u);
		return "registerForm";
	}

	@PostMapping("/register-action")
	public String saveUser(@ModelAttribute Usuario usuario, BindingResult result, Model model,
			RedirectAttributes redir) {

		Usuario u = usuarioService.saveUsuario(usuario);
		
		if (u == null) {
			redir.addFlashAttribute("message", "Problema al guardar el usuario");
			return "redirect:/auth/register?error=true";
		}

		redir.addFlashAttribute("RegistroExitoso", "RegistroExitoso");
		model.addAttribute("usuario", u);
		return "redirect:/";

	}

}
