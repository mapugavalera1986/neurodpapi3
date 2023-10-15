package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeados.AsignarMapeados;
import org.pe.neurodispuesta.modelos.Asignar;
import org.pe.neurodispuesta.repositorios.IAsignarRepository;
import org.pe.neurodispuesta.transferencias.AsgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignarService {
	
	@Autowired
	private IAsignarRepository r_asignaciones;
	
	@Autowired
	private AsignarMapeados mp_asignaciones;
		
	public List<AsgnDto> listar(){
		List<Asignar> l_sin_procesar = r_asignaciones.findAll();
		List<AsgnDto> l_procesada = l_sin_procesar.stream()
			.map(c -> mp_asignaciones.crearDto(c))
			.collect(Collectors.toList());
		return l_procesada;
	}
	
	public AsgnDto buscar(int id) {
		return mp_asignaciones.crearDto(r_asignaciones.findById(id).get());
	}
}
