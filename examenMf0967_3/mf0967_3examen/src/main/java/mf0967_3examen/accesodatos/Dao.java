package mf0967_3examen.accesodatos;

public interface Dao<T> {

	Iterable<T> listar();
	T obtenerPorId(Long id);

	T darDeAlta(T objeto);

	T modificar(T objeto);

	void eliminar(Long id);

}