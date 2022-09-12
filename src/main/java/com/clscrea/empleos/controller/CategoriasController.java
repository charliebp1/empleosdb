package com.clscrea.empleos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clscrea.empleos.service.ICategoriasService;
import com.clscrea.empleos.model.Categoria;
import com.clscrea.empleos.model.Vacante;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {

	@Autowired
	@Qualifier("categoriasServiceJpa")
	private ICategoriasService serviceCategorias;
	
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List <Categoria> lista = serviceCategorias.buscarTodas();
		model.addAttribute("categorias", lista);
		
		return "categorias/listCategorias";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) { 
		Page<Categoria> lista = serviceCategorias.buscarTodas(page); 
		model.addAttribute("categorias", lista);
        
		return "categorias/listCategorias";
	}
	
	// @RequestMapping(value="/create", method=RequestMethod.GET)
	@GetMapping("/create")
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@PostMapping("/save")
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrió un error: "+ error.getDefaultMessage());
			}
		    return "categorias/formCategorias";
		}
		
		// Guardamos el objeto categoría en la bbdd
		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro Guardado!");
	    return "redirect:/categorias/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idCategoria, Model model) {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	// @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idCategoria, RedirectAttributes attributes) {
		System.out.println("Borrando categoria con id: " + idCategoria);
		// Eliminamos la categoría.
		serviceCategorias.eliminar(idCategoria);
		attributes.addFlashAttribute("msg", "La categoría fue eliminada!");
		return "redirect:/categorias/index";
	}
}
