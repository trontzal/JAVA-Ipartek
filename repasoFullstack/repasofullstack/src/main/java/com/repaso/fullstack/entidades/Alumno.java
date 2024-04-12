package com.repaso.fullstack.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;


@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank
	private String nombre;
	
	@NotNull
	@NotBlank
	private String apellidos;
	
	@Past
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Min(0)
	@Max(10)
	private BigDecimal nota;
	
	@ManyToMany(mappedBy = "alumnos")
	private Set<Curso> cursos;

	public Alumno(long id, String nombre, String apellidos, LocalDate fechaNacimineto, BigDecimal nota,
			Set<Curso> cursos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimineto;
		this.nota = nota;
		this.cursos = cursos;
	}

	public Alumno() {
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimineto="
				+ fechaNacimiento + ", nota=" + nota + ", cursos=" + cursos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, cursos, fechaNacimiento, id, nombre, nota);
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
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && id == other.id
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
		return fechaNacimiento;
	}

	public void setFechaNacimineto(LocalDate fechaNacimineto) {
		this.fechaNacimiento = fechaNacimineto;
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
