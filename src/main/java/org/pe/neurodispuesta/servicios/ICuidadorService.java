package org.pe.neurodispuesta.servicios;

import java.util.List;

import org.pe.neurodispuesta.modelos.Cuidador;

public interface ICuidadorService {
	public List<Cuidador> listarTodos();
	public Cuidador buscar(int id);
	public Cuidador agregar(Cuidador c_nuevo);
	public Cuidador modificar(int id, Cuidador c_cambiar);
	public void eliminar(int id);
}
