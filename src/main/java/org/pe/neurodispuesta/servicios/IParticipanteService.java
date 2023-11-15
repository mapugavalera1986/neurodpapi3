package org.pe.neurodispuesta.servicios;

import java.text.ParseException;
import java.util.List;

import org.pe.neurodispuesta.transferencias.ParticipanteDTO;

public interface IParticipanteService {
	public List<ParticipanteDTO> listarTodos();
	public ParticipanteDTO buscar(int id);
	public ParticipanteDTO agregar(ParticipanteDTO p_nuevo) throws ParseException;
	public ParticipanteDTO modificar(int id, ParticipanteDTO p_cambiar);
	public void eliminar(int id);
}
