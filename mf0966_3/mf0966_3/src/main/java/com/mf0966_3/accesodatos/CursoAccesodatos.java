package com.mf0966_3.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mf0966_3.dtos.CursoDTO;
import com.mf0966_3.dtos.CursoResenaDTO;
import com.mf0966_3.dtos.ProfesorDTO;
import com.mf0966_3.dtos.ResenaDTO;

public class CursoAccesodatos {

	private static final String SQL_SELECT = "SELECT c.codigo, c.nombre, c.identificador, c.nHoras, p.codigo, p.nombre, p.apellidos FROM curso AS c JOIN profesor AS p  ON c.profesor_codigo = p.codigo ";
	private static final String SQL_SELECT_CODIGO = "SELECT c.codigo, c.nombre, c.identificador, c.nHoras, r.codigo, r.puntos, r.texto, r.alumno_codigo, r.curso_codigo FROM curso c LEFT JOIN puntuacion r ON c.codigo = r.curso_codigo LEFT JOIN alumno a ON r.alumno_codigo = a.codigo WHERE c.codigo = ?";

	public static ArrayList<CursoDTO> obtenerTodos() {
		var cursos = new ArrayList<CursoDTO>();

		try (Connection con = Accesodatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			CursoDTO curso;
			ProfesorDTO profesor;

			while (rs.next()) {
				profesor = new ProfesorDTO(rs.getLong("p.codigo"), rs.getString("p.nombre"),
						rs.getString("p.apellidos"));
				curso = new CursoDTO(rs.getLong("c.codigo"), rs.getString("c.nombre"), rs.getString("c.identificador"),
						rs.getInt("c.nHoras"), profesor);

				cursos.add(curso);
			}
			return cursos;
		} catch (SQLException e) {
			throw new RuntimeException("Error al conseguir listado de cursos", e);
		}
	}

	public static CursoResenaDTO obtenerPorCodigo(Long codigo) {
	    try (Connection con = Accesodatos.obtenerConexion();
	         PreparedStatement pst = con.prepareStatement(SQL_SELECT_CODIGO)) {
	        pst.setLong(1, codigo);

	        ResultSet rs = pst.executeQuery();

	        CursoResenaDTO curso = null;

	        while (rs.next()) {
	            if (curso == null) {
	                curso = new CursoResenaDTO(rs.getLong("c.codigo"), rs.getString("c.nombre"), rs.getString("c.identificador"),
	                        rs.getInt("c.nHoras"), new ArrayList<>());
	            }

	            ResenaDTO resena = new ResenaDTO(rs.getLong("r.codigo"), rs.getLong("r.puntos"), rs.getString("r.texto"), rs.getLong("r.alumno_codigo"), rs.getLong("r.curso_codigo"));

	            curso.resena().add(resena);
	        }

	        return curso;
	    } catch (SQLException e) {
	        throw new RuntimeException("Error al buscar cursos por codigo", e);
	    }
	}



}
