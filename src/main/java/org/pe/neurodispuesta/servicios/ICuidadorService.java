package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.Optional;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.transferencia.CuidadorDto;

public interface ICuidadorService {
	List<CuidadorDto> listarTodos();
	Optional<CuidadorDto> buscar(int id);
	CuidadorDto agregar(CuidadorDto c_nuevo);
	CuidadorDto modificar(int id, CuidadorDto c_cambiar);
	void eliminar(int id);
}
