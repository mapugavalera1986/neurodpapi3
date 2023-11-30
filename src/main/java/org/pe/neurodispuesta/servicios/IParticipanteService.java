package org.pe.neurodispuesta.servicios;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.transferencia.ParticipanteDto;

public interface IParticipanteService {
	List<ParticipanteDto> listarTodos();
	Optional<ParticipanteDto> buscar(int id);
	//List<ParticipanteDto> buscarCuidador(int cuidadorId);
	ParticipanteDto agregar(ParticipanteDto p_nuevo) throws ParseException;
	ParticipanteDto modificar(int id, ParticipanteDto p_cambiar);
	void eliminar(int id);
}
