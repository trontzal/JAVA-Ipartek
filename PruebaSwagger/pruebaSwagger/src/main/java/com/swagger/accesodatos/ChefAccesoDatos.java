package com.swagger.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.swagger.dtos.ChefDTO;

public class ChefAccesoDatos {
	private static final String SQL_SELECT = "SELECT c.id, c.nombre, c.experiencia, c.certificado FROM chefs AS c";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";

	public static ArrayList<ChefDTO> obtenerTodos() {
		var chefs = new ArrayList<ChefDTO>();

		try (Connection con = Accesodatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			ChefDTO chef;

			while (rs.next()) {
				chef = new ChefDTO(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getInt("c.experiencia"),
						rs.getBoolean("c.certificado"));

				chefs.add(chef);
			}
			return chefs;
		} catch (SQLException e) {
			throw new RuntimeException("Error en la select", e);
		}
	}

	public static ChefDTO obtenerPorId(Long id) {
		try (Connection con = Accesodatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return new ChefDTO(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getInt("c.experiencia"),
						rs.getBoolean("c.certificado"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error buscando por id", e);
		}
	}
}
