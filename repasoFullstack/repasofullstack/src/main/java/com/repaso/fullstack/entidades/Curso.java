package com.repaso.fullstack.entidades;

import java.util.Objects;
import java.util.Set;

public class Curso {

	private long id;
	private String nombre;
	private Set<Alumno> alumnos;

	public Curso(long id, String nombre, Set<Alumno> alumnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	public Curso() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumnos, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(alumnos, other.alumnos) && id == other.id && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
