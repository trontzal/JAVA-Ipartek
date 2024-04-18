package com.repaso.fullstack.dto;

import java.time.LocalDate;

public record AlumnoLoginDto(Long id, String email, String password, String nombre, String apellidos, LocalDate fechaNacimiento) {

}
