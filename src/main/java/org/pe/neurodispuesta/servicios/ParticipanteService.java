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
	private IParticipanteRepository r_participantees;
	
	@Autowired
	private ParticipanteMapeadosSimples mapa_participantes;
	
	@Autowired
	private ParticipanteMapeadosCompletos mapa_participantes_todo;
	
	public List<SimplePrtcDto> listar(){
		List<Participante> p_lista = r_participantees.findAll();
		List<SimplePrtcDto> p_lista_dto = p_lista.stream()
			.map(prt -> mapa_participantes.crearDto(prt))
			.collect(Collectors.toList());
		return p_lista_dto;
	}
	
	public List<CompletoPrtcDto> listarCompleto(){
		List<Participante> p_lista = r_participantees.findAll();
		List<CompletoPrtcDto> p_lista_dto = p_lista.stream()
			.map(prt -> mapa_participantes_todo.crearDto(prt))
			.collect(Collectors.toList());
		return p_lista_dto;
	}
	
	public SimplePrtcDto buscar(int id) {
		return mapa_participantes.crearDto(r_participantees.findById(id).get());
	}
	
	public Participante ingresar(Participante nuevo_c) {
		return r_participantees.saveAndFlush(nuevo_c);
	}
	
	public void eliminar(int id) {
		r_participantees.deleteById(id);
	}
}