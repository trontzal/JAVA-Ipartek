package com.springpruebas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringpruebasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringpruebasApplication.class, args);
	}

//	@Autowired
//	private ProductoRepository repo;

//	@Override
//	public void run(String... args) throws Exception {
//		repo.save(Producto.builder().nombre("prueba 1").precio(new BigDecimal(203)).build());
//		
//		for(var p: repo.findAll()) {
//			System.out.println(p);
//		}
//		
//	}
}
