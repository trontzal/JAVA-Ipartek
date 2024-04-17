package com.repaso.fullstack.dto;

import java.time.LocalDate;

public record AlumnoDto(Long id, String nombre, String apellidos, LocalDate fechaNacimiento) {

}
