package com.recetas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recetas.entidades.Ingrediente;
import com.recetas.entidades.Plato;
import com.recetas.entidades.PlatoIngrediente;
import com.recetas.entidades.Usuario;
import com.recetas.repositorios.DificultadRepository;
import com.recetas.repositorios.IngredienteRepository;
import com.recetas.repositorios.PlatoIngredienteRepository;
import com.recetas.repositorios.PlatoRepository;
import com.recetas.repositorios.TipoCocinaRepository;
import com.recetas.repositorios.UsuarioRepository;


@Service
public class RecetaServiceImpl implements RecetaService{

	
	@Autowired
	private PlatoIngredienteRepository platoIngredienteRepository;
	
	private IngredienteRepository ingredienteRepository;
	
	private PlatoRepository platoRepository;
	
	private DificultadRepository dificultadRepository;
	
	private TipoCocinaRepository tipoCocinaRepository;
	
	public RecetaServiceImpl(UsuarioRepository usuarioRepository, PlatoRepository platoRepository, IngredienteRepository ingredienteRepository, DificultadRepository dificultadRepository, TipoCocinaRepository tipoCocinaRepository) {
		usuarioRepository.save(Usuario.builder().nombre("Javier").email("javier@email.net").password("$2a$12$mof.u/4EIo58hR7On9DnPevyqBC7kb9FHzT.LN/BjF8xOqQVTP1NO").rol("ADMIN").build());
		usuarioRepository.save(Usuario.builder().nombre("Pepe").email("pepe@email.net").password("$2a$12$Dij9cgV3mXDQYtOo4nvQTOLaUz3URoe7DGjhBrqGa1fEEzkNVhBgq").rol("USER").build());
		
		this.platoRepository = platoRepository;
		this.ingredienteRepository = ingredienteRepository;
		this.dificultadRepository = dificultadRepository;
		this.tipoCocinaRepository = tipoCocinaRepository;
	}
	
	@Override
	public Iterable<Ingrediente> listarIngredientes() {
		return ingredienteRepository.findAll();
	}
	
	@Override
	public void anadirIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	@Override
	public void anadirPlato(Plato plato) {
		platoRepository.save(plato);
	}

	@Override
	public void anadirIngredienteAPlato(PlatoIngrediente platoIngrediente) {
		platoIngredienteRepository.save(platoIngrediente);
	}

	@Override
	public Iterable<Plato> listadoPlatos() {
		return platoRepository.findAll();
	}


}
