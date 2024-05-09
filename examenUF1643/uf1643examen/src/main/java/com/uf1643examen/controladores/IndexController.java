package com.uf1643examen.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uf1643examen.entidades.Libro;
import com.uf1643examen.servicios.LibroService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private LibroService libroService;

	@GetMapping({ "/", "libros" })
	private String listadoLibros(Model modelo) {
		modelo.addAttribute("libros", libroService.listadoLibros());
		return "index";
	}

	@GetMapping("libro/{id}")
	private String detalleLibro(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("libro", libroService.verLibro(id));
		return "detalleLibro";
	}

	@GetMapping("/buscarLibroPorIsbn")
	public String buscarLibroPorIsbn(@RequestParam("isbn") Long isbn, Model modelo) {
		Libro libro = libroService.buscarPorIsbn(isbn);
		modelo.addAttribute("libro", libro);
		return "libroPorIsbn";
	}

	@GetMapping("/buscarLibroPorNombre")
    public String buscarLibroPorNombre(@RequestParam("nombre") String nombre, Model modelo) {
        Iterable<Libro> libros = libroService.buscarPorNombre(nombre);
        modelo.addAttribute("libros", libros);
        return "libroPorNombre";
    }
}
