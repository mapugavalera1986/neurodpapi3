package org.pe.neurodispuesta.servicios;

import java.util.List;

import org.pe.neurodispuesta.transferencias.CuidadorDTO;

public interface ICuidadorService {
	public List<CuidadorDTO> listarTodos();
	public CuidadorDTO buscar(int id);
	public CuidadorDTO agregar(CuidadorDTO c_nuevo);
	public CuidadorDTO modificar(int id, CuidadorDTO c_cambiar);
	public void eliminar(int id);
}
