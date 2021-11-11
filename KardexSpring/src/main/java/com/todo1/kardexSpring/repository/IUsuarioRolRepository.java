package com.todo1.kardexSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.kardexSpring.model.Usuario_Rol;
import com.todo1.kardexSpring.model.embeddedId.Usuario_RolID;

@Repository
public interface IUsuarioRolRepository extends JpaRepository<Usuario_Rol, Usuario_RolID>{

}
