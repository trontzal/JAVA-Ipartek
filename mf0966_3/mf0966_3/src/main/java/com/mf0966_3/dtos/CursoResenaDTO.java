package com.mf0966_3.dtos;

import java.util.List;

public record CursoResenaDTO(Long codigo, String nombre, String identificador, Integer nHoras, List<ResenaDTO> resena) {

}
