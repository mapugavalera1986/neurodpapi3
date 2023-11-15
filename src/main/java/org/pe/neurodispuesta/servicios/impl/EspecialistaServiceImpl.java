package org.pe.neurodispuesta.servicios.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeadores.EspecialistaMapper;
import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.servicios.IEspecialistaService;
import org.pe.neurodispuesta.transferencias.EspecialistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EspecialistaServiceImpl implements IEspecialistaService{
	
	@Autowired
	private IEspecialistaRepository r_especialistas;
	
	@Autowired
	private EspecialistaMapper mp_especialistas;

	@Override
	public List<EspecialistaDTO> listarTodos() {
		List<Especialista> l_parcial = r_especialistas.findAll();
		return l_parcial.stream().map(mp_especialistas::crearDto).collect(Collectors.toList());	}

	@Override
	public EspecialistaDTO buscar(int id) {
		return mp_especialistas.crearDto(r_especialistas.findById(id).get());
	}

	@Override
	public EspecialistaDTO agregar(EspecialistaDTO c_nuevo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EspecialistaDTO modificar(int id, EspecialistaDTO e_cambiar) {
		Optional<Especialista> p_encontrado = r_especialistas.findById(id);
		if(p_encontrado.isPresent()) {
			Especialista e_procesado = p_encontrado.get();
			e_procesado.setNmbrs(e_cambiar.getNmbrs());
			e_procesado.setApllds(e_cambiar.getApllds());
			e_procesado.setDni(e_cambiar.getDni());
			e_procesado.setRuc(e_cambiar.getRuc());
			e_procesado.setCorreoE(e_cambiar.getCorreoE());
			e_procesado.setTelf(e_cambiar.getTelf());
			e_procesado.setFechaIngreso(e_cambiar.getFechaIngreso());
			e_procesado.setActivo(e_cambiar.isActivo());
			return mp_especialistas.crearDto(r_especialistas.saveAndFlush(e_procesado));
		} else {
			return null;
		}
	}

	@Override
	public void eliminar(int id) {
		Optional<Especialista> p_eliminado = r_especialistas.findById(id);
		if(p_eliminado.isPresent()) {
			r_especialistas.deleteById(id);
		}
	}

	@Override
	public void cambiarActivation(int id) {
		Optional<Especialista> p_encontrado = r_especialistas.findById(id);
		if(p_encontrado.isPresent()) {
			Especialista e_procesado = p_encontrado.get();
			e_procesado.setActivo(!e_procesado.isActivo());
		}
	}

}
