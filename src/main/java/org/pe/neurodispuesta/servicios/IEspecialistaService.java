package org.pe.neurodispuesta.servicios;

import java.util.List;

import org.pe.neurodispuesta.modelos.Especialista;

public interface IEspecialistaService {
	public List<Especialista> listarTodos();
	public Especialista buscar(int id);
	public Especialista agregar(Especialista c_nuevo);
	public Especialista modificar(int id, Especialista c_cambiar);
	public boolean eliminar(int id);
	//public boolean cambiarActivation(int id);
}
