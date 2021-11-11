package com.todo1.kardexSpring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.todo1.kardexSpring.model.Usuario;
import com.todo1.kardexSpring.model.Usuario_Rol;

public class UsuarioModel extends Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5974188486933722811L;
	
	private Collection<? extends GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getNit();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public UsuarioModel(String nit, String password, int isActive, Collection<? extends GrantedAuthority> authorities) {

		super( nit, password, isActive, null);
		this.authorities = authorities;

	}

	public static UsuarioModel build(Usuario user) {

		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Usuario_Rol rol : user.getRoles()) {
			System.out.println(rol.getRol().getNombre().name());
			authorities.add(new SimpleGrantedAuthority(rol.getRol().getNombre().name()));
		}

		return new UsuarioModel( user.getNit(), user.getPassword(), user.getIsActive(), authorities);
	}
}
