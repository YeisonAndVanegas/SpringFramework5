package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework!2");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Vanegas");
		usuario.setEmail("yeison@correo.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del Usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listUsers")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de Usuarios");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres","Guzman","andres@correo.com"),
				new Usuario("Paola","Perez","perez@correo.com"),
				new Usuario("Camila","Ortiz","camila@correo.com"),
				new Usuario("Pedro","Velez","pedro@correo.com"));
		return usuarios;
	}

}
