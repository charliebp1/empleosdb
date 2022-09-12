package com.clscrea.empleos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.clscrea.empleos.model.Categoria;

public interface ICategoriasService {
	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);	
	Page<Categoria> buscarTodas(Pageable page);
	// Ejercicio: Implementar método
	void eliminar(Integer idCategoria);
}

