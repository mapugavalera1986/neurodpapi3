package org.pe.neurodispuesta.servicios;

import java.util.List;

import org.pe.neurodispuesta.transferencias.EspecialistaDTO;

public interface IEspecialistaService {
	public List<EspecialistaDTO> listarTodos();
	public EspecialistaDTO buscar(int id);
	public EspecialistaDTO agregar(EspecialistaDTO c_nuevo);
	public EspecialistaDTO modificar(int id, EspecialistaDTO c_cambiar);
	public void eliminar(int id);
	public void cambiarActivation(int id);
}
