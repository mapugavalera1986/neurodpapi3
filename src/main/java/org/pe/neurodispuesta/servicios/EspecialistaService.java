package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeados.EspecialistaMapeadosSimples;
import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.transferencias.SimpleEspcDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialistaService {
	
	@Autowired
	private IEspecialistaRepository r_especialistas;
	
	@Autowired
	private EspecialistaMapeadosSimples mapa_especialistas;
	
	public List<SimpleEspcDto> listar(){
		List<Especialista> e_lista = r_especialistas.findAll();
		List<SimpleEspcDto> e_lista_dto = e_lista.stream()
			.map(e -> mapa_especialistas.crearDto(e))
			.collect(Collectors.toList());
		return e_lista_dto;
	}
	
	public SimpleEspcDto buscar(int id) {
		return mapa_especialistas.crearDto(r_especialistas.findById(id).get());
	}
}
