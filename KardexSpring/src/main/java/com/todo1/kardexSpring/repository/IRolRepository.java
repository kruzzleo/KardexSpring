package com.todo1.kardexSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.kardexSpring.model.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{

}
