package com.examen.uf2216.entidades.daos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.examen.uf2216.entidades.Libro;

public class DaoFabricaProvider implements LibroDaoFabrica {

	@Override
	public LibroDao<Libro> getLibroDao() {
		Properties properties = new Properties();
		FileInputStream inputStream = null;

		try {
			inputStream = new FileInputStream("src/config.properties");
			properties.load(inputStream);
			String daoType = properties.getProperty("dao.type");

			if (daoType == null) {
				throw new IllegalArgumentException("Tipo de DAO no especificado en config.properties");
			}

			switch (daoType) {
			case "ArrayList":
				return new LibroDaoArrayList();
			case "csv":
				String filePath = "src/libros.csv";
				return new LibroDaoCSV(filePath);
			default:
				throw new IllegalArgumentException("Tipo de DAO desconocido: " + daoType);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al cargar el archivo de configuración", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
