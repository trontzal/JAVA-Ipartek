package com.mf0966_3.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mf0966_3.dtos.ResenaDTO;

public class ResenaAccesodatos {
	private static final String SQL_INSERT = "INSERT INTO puntuacion (puntos, texto, alumno_codigo, curso_codigo) VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE puntuacion SET puntos=?, texto = ?, alumno_codigo = ?, curso_codigo = ? WHERE codigo = ?";
	private static final String SQL_DELETE = "DELETE FROM puntuacion WHERE codigo = ?";

	public static ResenaDTO insertar(ResenaDTO resena) {
		try (Connection con = Accesodatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {
			pst.setLong(1, resena.puntos());
			pst.setString(2, resena.texto());
			pst.setLong(3, resena.alumno_codigo());
			pst.setLong(4, resena.curso_codigo());
			
			pst.executeUpdate();
			
			return resena;
		} catch (SQLException e) {
			throw new RuntimeException("Insertar reseña a dado error", e);
		}
	}
	
	public static ResenaDTO modificar(ResenaDTO resena, Long codigo) {
		try (Connection con = Accesodatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {
			pst.setLong(1, resena.puntos());
			pst.setString(2, resena.texto());
			pst.setLong(3, resena.alumno_codigo());
			pst.setLong(4, resena.curso_codigo());
			pst.setLong(5, codigo);
			
			pst.executeUpdate();
			
			return resena;
		} catch (SQLException e) {
			throw new RuntimeException("Modificar reseña a dado error", e);
		}
	}
	
	public static void borrar(Long codigo) {
		try (Connection con = Accesodatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {
			pst.setLong(1, codigo);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error al eliminar la reseña", e);
		}
		
	}
	
}
