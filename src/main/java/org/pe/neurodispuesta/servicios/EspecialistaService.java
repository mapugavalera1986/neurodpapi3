package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeadores.EspecialistaMapper;
import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.transferencias.EspecialistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialistaService {
	
	@Autowired
	private IEspecialistaRepository r_especialistas;
	
	@Autowired
	private EspecialistaMapper mp_especialistas;

	public List<EspecialistaDTO> listarTodos(){
		List<Especialista> l_parcial = r_especialistas.findAll();
		return l_parcial.stream().map(mp_especialistas::crearDto).collect(Collectors.toList());
	}
	
	public List<EspecialistaDTO> listarActivos(){
		List<Especialista> l_parcial = r_especialistas.findAllByActivo(true);
		return l_parcial.stream().map(mp_especialistas::crearDto).collect(Collectors.toList());
	}
	
	public Optional<EspecialistaDTO> buscar(int id){
		Optional<Especialista> p_buscado = r_especialistas.findById(id);
		return p_buscado.map(mp_especialistas::crearDto);
	}
	
	public Optional<EspecialistaDTO> buscarActivo(int id, boolean activo){
		Optional<Especialista> p_buscado = r_especialistas.findByEspecialistaIdAndActivo(id, activo);
		return p_buscado.map(mp_especialistas::crearDto);
	}
	
	public EspecialistaDTO agregar(EspecialistaDTO p_nuevo) {
		Especialista p_procesado = mp_especialistas.crearEntidad(p_nuevo);
		return mp_especialistas.crearDto(r_especialistas.saveAndFlush(p_procesado));
	}
	
	public EspecialistaDTO modificar(int id, EspecialistaDTO p_cambiar) {
		Optional<Especialista> p_encontrado = r_especialistas.findById(id);
		if(p_encontrado.isPresent()) {
			Especialista p_procesado = p_encontrado.get();
			p_procesado.setNmbrs(p_cambiar.getNmbrs());
			p_procesado.setApllds(p_cambiar.getApllds());
			p_procesado.setDni(p_cambiar.getDni());
			p_procesado.setRuc(p_cambiar.getRuc());
			p_procesado.setCorreoE(p_cambiar.getCorreoE());
			p_procesado.setTelf(p_cambiar.getTelf());
			p_procesado.setFechaIngreso(p_cambiar.getFechaIngreso());
			return mp_especialistas.crearDto(r_especialistas.saveAndFlush(p_procesado));
		} else {
			return null;
		}
	}
	
	public void eliminar(int id) {
		Optional<Especialista> p_eliminado = r_especialistas.findById(id);
		if(p_eliminado.isPresent()) {
			// p_eliminado_total = p_eliminado.get(); aquí se elimina todo
			r_especialistas.deleteById(id);
		}
	}
	
}
