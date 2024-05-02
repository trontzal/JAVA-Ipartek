package com.recetas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recetas.entidades.Ingrediente;
import com.recetas.entidades.Plato;
import com.recetas.entidades.PlatoIngrediente;
import com.recetas.repositorios.PlatoRepository;


// En el github no esta puesto lo de service
@Service
public class RecetaServiceImpl implements RecetaService{

	@Autowired
	private PlatoRepository platoRepository;
	
	@Override
	public void anadirIngrediente(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anadirPlato(Plato plato) {
		platoRepository.save(plato);
	}

	@Override
	public void anadirIngredienteAPlato(PlatoIngrediente platoIngrediente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Plato> listadoPlatos() {
		return platoRepository.findAll();
	}

	@Override
	public Plato verPlato() {
		// TODO Auto-generated method stub
		return null;
	}

}
