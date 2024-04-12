package com.repaso.fullstack.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Alumno {

	private long id;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimineto;
	private BigDecimal nota;
	private Set<Curso> cursos;

	public Alumno(long id, String nombre, String apellidos, LocalDate fechaNacimineto, BigDecimal nota,
			Set<Curso> cursos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimineto = fechaNacimineto;
		this.nota = nota;
		this.cursos = cursos;
	}

	public Alumno() {
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimineto="
				+ fechaNacimineto + ", nota=" + nota + ", cursos=" + cursos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, cursos, fechaNacimineto, id, nombre, nota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(cursos, other.cursos)
				&& Objects.equals(fechaNacimineto, other.fechaNacimineto) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(nota, other.nota);
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(LocalDate fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

}
