package mf0967_3examen.entidades;

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

	private String autor;

//	@URL
	private String url;

	public Libro(@Min(0) Long id, @NotNull @Size(min = 2, max = 150) String nombre, @NotNull @Min(0) BigDecimal precio,
			@Min(0) @Max(100) Integer descuento, String autor, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		if (autor == null || autor.isEmpty()) {
			this.autor = "Anónimo";
		} else {
			this.autor = autor;
		}
		this.url = url;
	}

	public Libro(@Min(0) Long id, @NotNull @Size(min = 2, max = 150) String nombre,
			@NotNull @Min(0) BigDecimal precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Libro() {
		super();
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, descuento, id, nombre, precio, url);
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
		return Objects.equals(autor, other.autor) && Objects.equals(descuento, other.descuento)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + ", autor="
				+ autor + ", url=" + url + "]";
	}

}
