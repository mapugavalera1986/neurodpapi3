package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeados.ParticipanteMapeadosCompletos;
import org.pe.neurodispuesta.mapeados.ParticipanteMapeadosSimples;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.transferencias.CompletoPrtcDto;
import org.pe.neurodispuesta.transferencias.SimplePrtcDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private ParticipanteMapeadosSimples mp_participantes;
	
	@Autowired
	private ParticipanteMapeadosCompletos mp_participantes_todo;
	
	public List<SimplePrtcDto> listar(){
		List<Participante> l_sin_procesar = r_participantes.findAll();
		List<SimplePrtcDto> l_procesada = l_sin_procesar.stream()
			.map(c -> mp_participantes.crearDto(c))
			.collect(Collectors.toList());
		return l_procesada;
	}
	
	public CompletoPrtcDto buscar(int id) {
		return mp_participantes_todo.crearDto(r_participantes.findById(id).get());
	}
}
