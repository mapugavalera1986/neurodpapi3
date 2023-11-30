package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.Optional;

import org.pe.neurodispuesta.transferencia.EspecialistaDto;

public interface IEspecialistaService {
	List<EspecialistaDto> listarTodos();
	Optional<EspecialistaDto> buscar(int id);
	EspecialistaDto agregar(EspecialistaDto c_nuevo);
	EspecialistaDto modificar(int id, EspecialistaDto c_cambiar);
	void eliminar(int id);
}
