package com.uf2215gonzalo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uf2215gonzalo.dtos.AutorDTO;
import com.uf2215gonzalo.dtos.LibroDTO;

public class LibroAccesodatos {
	private static final Logger LOG = Logger.getLogger(LibroAccesodatos.class.getName());
	
	private static final String SQL_LIMIT = " LIMIT 100";
	private static final String SQL_ORDER_BY = " ORDER BY l.titulo";
	private static final String SQL_SELECT = " SELECT l.id, l.titulo, l.isbn, a.id, a.nombre, a.apellidos FROM autores AS a JOIN libros AS l ON a.id = l.autores_id";
	private static final String SQL_SELECT_TITULO = SQL_SELECT + " WHERE l.titulo like ?";

	public static ArrayList<LibroDTO> obtenerTodos() {
		var libros = new ArrayList<LibroDTO>();
		
		LOG.log(Level.INFO, "Peticion de listado");

		try (Connection con = Accesodatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT + SQL_ORDER_BY + SQL_LIMIT);
				ResultSet rs = pst.executeQuery()) {
			LibroDTO libro;
			AutorDTO autor;

			while (rs.next()) {
				autor = new AutorDTO(rs.getLong("a.id"), rs.getString("a.nombre"), rs.getString("a.apellidos"));

				libro = new LibroDTO(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.isbn"), autor);

				libros.add(libro);
			}
			return libros;
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "No se han podido obtener los libros con los autores", e);
			throw new RuntimeException("Error al buscar el listado de libros", e);
		}
	}

	public static ArrayList<LibroDTO> buscar(String titulo) {
		var libros = new ArrayList<LibroDTO>();
		
		LOG.log(Level.INFO, "Se han buscado libros con el titulo " + titulo);
		
		try (Connection con = Accesodatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_TITULO + SQL_ORDER_BY + SQL_LIMIT)) {

			pst.setString(1, "%" + titulo + "%");

			ResultSet rs = pst.executeQuery();

			LibroDTO libro;
			AutorDTO autor;

			while (rs.next()) {
				autor = new AutorDTO(rs.getLong("a.id"), rs.getString("a.nombre"), rs.getString("a.apellidos"));

				libro = new LibroDTO(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.isbn"), autor);

				libros.add(libro);
			}
			return libros;
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "No se han podido obtener los libros buscando por titulo", e);
			throw new RuntimeException("Error al buscar por titulo", e);
		}
	}
}
