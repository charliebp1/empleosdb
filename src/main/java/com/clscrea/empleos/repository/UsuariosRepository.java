package com.clscrea.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clscrea.empleos.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByUsername(String username);
	
}
