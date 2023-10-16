	package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeados.EspecialistaMapeados;
import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.transferencias.EspcDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialistaService {
	
	@Autowired
	private IEspecialistaRepository r_especialistas;
	
	@Autowired
	private EspecialistaMapeados mp_especialistas;
		
	public List<EspcDto> listar(){
		List<Especialista> l_sin_procesar = r_especialistas.findAll();
		List<EspcDto> l_procesada = l_sin_procesar.stream()
			.map(c -> mp_especialistas.crearDto(c))
			.collect(Collectors.toList());
		return l_procesada;
	}
	
	public List<EspcDto> listarActivos(){
		List<Especialista> l_sin_procesar = r_especialistas.findAllByActivo(true);
		List<EspcDto> l_procesada = l_sin_procesar.stream()
			.map(c -> mp_especialistas.crearDto(c))
			.collect(Collectors.toList());
		return l_procesada;
	}
	
	public EspcDto buscar(int id) {
		return mp_especialistas.crearDto(r_especialistas.findById(id).get());
	}
	
	public EspcDto agregar(EspcDto ingresar_c) {
		ingresar_c.setEspecialistaId(0);
		Especialista egresar = mp_especialistas.convertir(ingresar_c);
		return mp_especialistas.crearDto(r_especialistas.saveAndFlush(egresar));
	}
	
	public EspcDto modificar(int id, EspcDto modificar_e) throws Exception {
		if(r_especialistas.findById(id).isPresent()) {
			modificar_e.setEspecialistaId(id);
			Especialista egresar = mp_especialistas.convertir(modificar_e);
			return mp_especialistas.crearDto(r_especialistas.saveAndFlush(egresar));
		} else {
			throw new IllegalArgumentException("Necesitas un ID para su modificación");
		}
	}
	
	public boolean eliminar(int id) {
		if(r_especialistas.findById(id).isPresent()) {
			r_especialistas.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
