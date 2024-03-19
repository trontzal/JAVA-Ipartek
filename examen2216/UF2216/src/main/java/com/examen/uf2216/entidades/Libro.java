package com.examen.uf2216.entidades;

import java.util.Objects;

public class Libro {

	private String titulo;
	private Long isbn;
	private Integer nPaginas;
	private Boolean formato;
	
	
	
	// Constructores
	public Libro(String titulo, Long isbn, Integer nPaginas, Boolean formato) {
		setTitulo(titulo);
		setIsbn(isbn);
		setnPaginas(nPaginas);
		setFormato(formato);
	}
	
	public Libro(Libro libros) {
		this(libros.getTitulo(), libros.getIsbn(), libros.getnPaginas(), libros.getFormato());
	}
	
	//Por defecto es un libro a papel
	public Libro(String titulo, Long isbn, Integer nPaginas) {
		this(titulo, isbn, nPaginas, false);
	}



	// Setters y getters
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		if(titulo.length() <= 2 || titulo.length() >= 150) {
			throw new RuntimeException("El titulo tiene que estar entre 3 y 150 letras");
		}
		this.titulo = titulo;
	}


	public Long getIsbn() {
		return isbn;
	}


	public void setIsbn(Long isbn) {
		if(isbn.toString().length() != 10) {
			throw new RuntimeException("El isbn tiene que tener una longitud de 10");
		}
		this.isbn = isbn;
	}


	public Integer getnPaginas() {
		return nPaginas;
	}


	public void setnPaginas(Integer nPaginas) {
		if(nPaginas < 1) {
			throw new RuntimeException("El numero de paginas tiene que ser como minimo 1");
		}
		this.nPaginas = nPaginas;
	}


	public Boolean getFormato() {
		return formato;
	}


	public void setFormato(Boolean formato) {
		this.formato = formato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(formato, isbn, nPaginas, titulo);
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
		return Objects.equals(formato, other.formato) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(nPaginas, other.nPaginas) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", isbn=" + isbn + ", nPaginas=" + nPaginas + ", formato=" + formato + "]";
	}
	
	
}
