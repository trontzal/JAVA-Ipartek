package com.recetas.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recetas.servicios.RecetaService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private RecetaService servicio;

	@GetMapping({ "/", "platos" })
	private String listadoPlatos(Model modelo) {
		modelo.addAttribute("platos", servicio.listadoPlatos());

		return "platos";
	}

	@GetMapping("ingredientes")
	private String listadoDePlatos(Model modelo) {
		modelo.addAttribute("ingredientes", servicio.listarIngredientes());
		return "ingredientes";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}

}
