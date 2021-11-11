package com.todo1.kardexSpring.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.todo1.kardexSpring.model.Factura;
import com.todo1.kardexSpring.model.Kardex;
import com.todo1.kardexSpring.model.Rol;
import com.todo1.kardexSpring.model.Usuario;
import com.todo1.kardexSpring.model.Usuario_Rol;
import com.todo1.kardexSpring.model.embeddedId.FacturaID;
import com.todo1.kardexSpring.model.embeddedId.Usuario_RolID;
import com.todo1.kardexSpring.model.enums.RolNombre;
import com.todo1.kardexSpring.repository.IUsuarioRolRepository;
import com.todo1.kardexSpring.service.IFacturaService;
import com.todo1.kardexSpring.service.IRolService;
import com.todo1.kardexSpring.service.IUsuarioRolService;
import com.todo1.kardexSpring.service.IUsuarioService;

@Service
public class CommandLineRun implements CommandLineRunner {

	@Autowired
	IUsuarioService user;

	@Autowired
	IRolService rolS;

	@Autowired
	IUsuarioRolService ur;

	@Autowired
	IFacturaService fs;

	@Override
	public void run(String... args) throws Exception {

		Rol rol = new Rol(RolNombre.ROLE_USER, null);
		rol = rolS.saveRol(rol);
//		
//		Rol rol2 = new Rol(RolNombre.ROLE_ADMIN, null);
//		rol2 = rolS.saveRol(rol2);
//
		Usuario user1 = new Usuario("useremail", "useremail", 1, null);
		user1 = user.saveUsuario(user1);
//   	    
//		Usuario user2 = new Usuario("useremail2", "useremail", 1, null);
//		user2 = user.saveUsuario(user2);
//		
		Usuario_Rol userrol = new Usuario_Rol(new Usuario_RolID(user1.getId(), rol.getId()), user1, rol);
		ur.saveUsuarioRol(userrol);
//		
//		Usuario_Rol userro2 = new Usuario_Rol(new Usuario_RolID(user2.getId(), rol2.getId()), user2, rol2);
//		ur.saveUsuarioRol(userro2);
//		
//		
//		Factura f1 = new Factura(user1);
//		fs.saveFactura(f1);
//
//		
//		Kardex kardex = new Kardex()
		
		
		
		
//		
//		Usuario_Rol userrol = new Usuario_Rol(new Usuario_RolID(a.getId(), rol.getId()), a, rol);
//		ur.saveUsuarioRol(userrol);
//		
//		Factura fac = new Factura(1,a);
//		fs.saveFactura(fac);
//
//
////		Factura fac = new Factura(new Usuario("useremail", "useremail", 1, null));
////		fs.saveFactura(fac);

	}

}
