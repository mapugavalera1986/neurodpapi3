package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeados.CuidadorMapeadosCompletos;
import org.pe.neurodispuesta.mapeados.CuidadorMapeadosSimples;
import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.transferencias.CddrDto;
import org.pe.neurodispuesta.transferencias.SimpleCddrDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuidadorService {
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	@Autowired
	private CuidadorMapeadosSimples mp_cuidadores;
	
	@Autowired
	private CuidadorMapeadosCompletos mp_cuidadores_todo;
	
	public List<SimpleCddrDto> listar(){
		List<Cuidador> l_sin_procesar = r_cuidadores.findAll();
		List<SimpleCddrDto> l_procesada = l_sin_procesar.stream()
			.map(c -> mp_cuidadores.crearDto(c))
			.collect(Collectors.toList());
		return l_procesada;
	}
	
	public CddrDto buscar(int id) {
		return mp_cuidadores_todo.crearDto(r_cuidadores.findById(id).get());
	}
}
