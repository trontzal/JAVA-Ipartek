package com.UF2218Examen.entidades;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Libro {

	@Min(0)
	private Long id;

	@NotNull
	@Size(min = 2, max = 150)
	private String nombre;

	@NotNull
	@Min(0)
	private BigDecimal precio;

	@Min(0)
	@Max(100)
	private Integer descuento;

	public Libro() {
	}

	public Libro(@Min(0) Long id, @NotNull @Size(min = 2, max = 150) String nombre, @NotNull @Min(0) BigDecimal precio,
			@Min(0) @Max(100) Integer descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descuento, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(descuento, other.descuento) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", Descuento=" + descuento + "]";
	}

}
