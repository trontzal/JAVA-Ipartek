package com.springpruebas;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springpruebas.entidades.Producto;
import com.springpruebas.repositorios.ProductoRepository;

@SpringBootApplication
public class SpringpruebasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringpruebasApplication.class, args);
	}

	@Autowired
	private ProductoRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(Producto.builder().nombre("prueba 1").precio(new BigDecimal(203)).build());
		
		for(var p: repo.findAll()) {
			System.out.println(p);
		}
		
	}
}
