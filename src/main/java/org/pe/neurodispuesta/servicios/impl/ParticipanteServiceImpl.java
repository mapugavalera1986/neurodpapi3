package org.pe.neurodispuesta.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.servicios.IParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParticipanteServiceImpl implements IParticipanteService{
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Override
	public List<Participante> listarTodos() {
		return r_participantes.findAll();
	}

	@Override
	public Participante buscar(int id) {
		Optional<Participante> p_buscado = r_participantes.findById(id);
		if(p_buscado.isPresent()) {
			return p_buscado.get();
		} else {
			return new Participante();
		}
	}

	@Override
	public Participante agregar(Participante p_nuevo) {
		return r_participantes.save(p_nuevo);
	}

	@Override
	public Participante modificar(int id, Participante p_cambiar) {
		Optional<Participante> p_encontrado = r_participantes.findById(id);
		if(p_encontrado.isPresent()) {
			p_cambiar.setParticipanteId(id);
			return r_participantes.saveAndFlush(p_cambiar);
		} else {
			return null;
		}
	}

	@Override
	public void eliminar(int id) {
		Optional<Participante> p_eliminado = r_participantes.findById(id);
		if(p_eliminado.isPresent()) {
			r_participantes.deleteById(id);
		}
	}
}
