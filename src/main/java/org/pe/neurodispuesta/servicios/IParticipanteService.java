package org.pe.neurodispuesta.servicios;

import java.text.ParseException;
import java.util.List;

import org.pe.neurodispuesta.modelos.Participante;

public interface IParticipanteService {
	public List<Participante> listarTodos();
	public Participante buscar(int id);
	public Participante agregar(Participante p_nuevo) throws ParseException;
	public Participante modificar(int id, Participante p_cambiar);
	public void eliminar(int id);
}
