package com.springpruebas.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springpruebas.entidades.Producto;
import com.springpruebas.servicios.AdminNegocio;
import com.springpruebas.servicios.UsuarioNegocio;

import jakarta.validation.Valid;

@RequestMapping("/")
@Controller
public class IndexController {

	@Autowired
	private UsuarioNegocio user;

	@Autowired
	private AdminNegocio admin;

	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("productos", user.obtenerTodos());
		return "index";
	}

	@GetMapping("admin")
	public String admin(Producto producto) {
		producto.setNombre("");
		return "admin";
	}

	@PostMapping("admin")
	private String adminPost(@Valid Producto producto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "admin";
		}
		admin.insertarProducto(producto);
		return "redirect:/";
	}
}
