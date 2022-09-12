package com.clscrea.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clscrea.empleos.model.Solicitud;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}
