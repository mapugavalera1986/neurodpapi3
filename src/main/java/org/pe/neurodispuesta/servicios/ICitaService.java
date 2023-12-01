package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.Optional;

import org.pe.neurodispuesta.transferencia.CitaDto;

public interface ICitaService {
	List<CitaDto> listarTodos();
	Optional<CitaDto> buscar(int id);
	CitaDto agregar(CitaDto c_nuevo);
	CitaDto modificar(int id, CitaDto c_cambiar);
	void eliminar(int id);
}
