package com.clscrea.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clscrea.empleos.model.Categoria;
import com.clscrea.empleos.model.Usuario;
import com.clscrea.empleos.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	@Qualifier("usuariosServiceJpa")
	private IUsuariosService usuarioService;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> lista = usuarioService.buscarTodos();
		model.addAttribute("usuarios", lista);

		// Ejercicio
		return "usuarios/listUsuarios";
	}

	@GetMapping("/create")

	public String crear() {
		return "usuarios/formRegistro";
	}

	@PostMapping("/save")
	public String guardar(Usuario usuario, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrió un error: " + error.getDefaultMessage());
			}
			return "usuarios/formRegistro";
		}
		usuarioService.guardar(usuario);
		attributes.addFlashAttribute("msg", "Registro Guardado!");
		return "redirect:/usuarios/index";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {
		System.out.println("Borrando usuario con id: " + idUsuario);
		usuarioService.eliminar(idUsuario);
		// Eliminamos el usuario
		attributes.addFlashAttribute("msg", "El usuario fue eliminado!");
		// Ejercicio.
		return "redirect:/usuarios/index";
	}
 
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
