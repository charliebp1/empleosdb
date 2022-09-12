package com.clscrea.empleos.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clscrea.empleos.model.Solicitud;
import com.clscrea.empleos.repository.SolicitudesRepository;
import com.clscrea.empleos.service.ISolicitudesService;

@Service
@Primary
public class SolicitudesServiceJpa implements ISolicitudesService {

	@Autowired
	private SolicitudesRepository solicitudesRepo;
	
	@Override
	public void guardar(Solicitud solicitud) {
	
		solicitudesRepo.save(solicitud);
	}

	@Override
	public void eliminar(Integer idSolicitud) {
		
		solicitudesRepo.deleteById(idSolicitud);
	}

	@Override
	public List<Solicitud> buscarTodas() {
		
		return solicitudesRepo.findAll();
	}

	@Override
	public Solicitud buscarPorId(Integer idSolicitud) {
		Optional<Solicitud> optional = solicitudesRepo.findById(idSolicitud);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Solicitud> buscarTodas(Pageable page) {
		
		return solicitudesRepo.findAll(page);
	}	

}
