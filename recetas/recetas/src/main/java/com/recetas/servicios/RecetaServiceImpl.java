package com.recetas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recetas.entidades.Ingrediente;
import com.recetas.entidades.Plato;
import com.recetas.entidades.PlatoIngrediente;
import com.recetas.repositorios.IngredienteRepository;
import com.recetas.repositorios.PlatoIngredienteRepository;
import com.recetas.repositorios.PlatoRepository;


// En el github no esta puesto lo de service
@Service
public class RecetaServiceImpl implements RecetaService{


	@Autowired
	private PlatoRepository platoRepository;
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Autowired
	private PlatoIngredienteRepository platoIngredienteRepository;
	
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
