package com.clscrea.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clscrea.empleos.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService {

	private List<Vacante> lista = null;
	
	public VacantesServiceImpl() {
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			lista = new LinkedList<Vacante>();
			try {
				// Creamos la oferta de Trabajo 1
				Vacante vacante1 = new Vacante();
				vacante1.setId(1);
				vacante1.setNombre("Ingeniero Civil"); // Título de la vacante
				vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal.");
				vacante1.setFecha(sdf.parse("15-11-2021"));
				vacante1.setSalario(14000.0);
				vacante1.setDestacado(1);
				vacante1.setEstatus("Aprobada");
				vacante1.setImagen("empresa1.png");
				
				// Creamos la oferta de Trabajo 2
				Vacante vacante2 = new Vacante();
				vacante2.setId(2);
				vacante2.setNombre("Contador Público"); // Título de la vacante
				vacante2.setDescripcion("Empresa importante solicita contador titulado con 5 años de experiencia.");
				vacante2.setFecha(sdf.parse("12-10-2021"));
				vacante2.setSalario(12000.0);
				vacante2.setDestacado(0);
				vacante2.setEstatus("Creada");
				vacante2.setImagen("empresa2.png");
				
				// Creamos la oferta de Trabajo 3
				Vacante vacante3 = new Vacante();
				vacante3.setId(3);
				vacante3.setNombre("Ingeniero Eléctrico"); // Título de la vacante
				vacante3.setDescripcion("Empresa internacional solicita Ingeniero mecánico para mantenimiento de la instalación eléctrica.");
				vacante3.setFecha(sdf.parse("10-09-2021"));
				vacante3.setSalario(10500.0);
				vacante3.setDestacado(0);
				vacante3.setEstatus("Aprobada");
				vacante3.setImagen("no-image.png");
				
				// Creamos la oferta de Trabajo 4
				Vacante vacante4 = new Vacante();
				vacante4.setId(4);
				vacante4.setNombre("Diseñador Gráfico"); // Título de la vacante
				vacante4.setDescripcion("Solicitamos Diseñador Gráfico titulado para diseñar publicidad de la empresa.");
				vacante4.setFecha(sdf.parse("09-11-2021"));
				vacante4.setSalario(7500.0);
				vacante4.setDestacado(1);
				vacante4.setEstatus("Creada");
				vacante4.setImagen("empresa3.png");
				
				/*
				 * Agregamos los 4 objetos de tipo Vacante a la lista ...
				 */
				lista.add(vacante1);
				lista.add(vacante2);
				lista.add(vacante3);
				lista.add(vacante4);
			} catch(ParseException pe) {
				System.out.println("Error: " + pe.getMessage());
			}
	}
	
	public List<Vacante> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}


	public Vacante buscarPorId(Integer idVacante) {
		
		for (Vacante v: lista) {
			if(v.getId() == idVacante) {
				return v;
			}
		}
		
		return null;
	}

	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		lista.add(vacante);
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		
		return null;
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
