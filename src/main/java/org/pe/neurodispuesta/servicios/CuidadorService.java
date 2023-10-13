package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeados.CuidadorMapeadosCompletos;
import org.pe.neurodispuesta.mapeados.CuidadorMapeadosSimples;
import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.transferencias.CompletoCddrDto;
import org.pe.neurodispuesta.transferencias.SimpleCddrDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuidadorService {
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	@Autowired
	private CuidadorMapeadosSimples mapa_cuidadores;
	
	@Autowired
	private CuidadorMapeadosCompletos mapa_cuidadores_todo;
	
	public List<SimpleCddrDto> listar(){
		List<Cuidador> l_sin_procesar = r_cuidadores.findAll();
		List<SimpleCddrDto> l_procesada = l_sin_procesar.stream()
			.map(c -> mapa_cuidadores.crearDto(c))
			.collect(Collectors.toList());
		return l_procesada;
	}
	
	public List<CompletoCddrDto> listarCompleto(){
		List<Cuidador> l_sin_procesar = r_cuidadores.findAll();
		List<CompletoCddrDto> l_procesada = l_sin_procesar.stream()
			.map(c -> mapa_cuidadores_todo.crearDto(c))
			.collect(Collectors.toList());
		return l_procesada;
	}
	
	public SimpleCddrDto buscar(int id) {
		return mapa_cuidadores.crearDto(r_cuidadores.findById(id).get());
	}
}
