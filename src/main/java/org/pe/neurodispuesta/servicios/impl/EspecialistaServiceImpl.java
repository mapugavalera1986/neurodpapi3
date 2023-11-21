package org.pe.neurodispuesta.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.servicios.IEspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EspecialistaServiceImpl implements IEspecialistaService{
	
	@Autowired
	private IEspecialistaRepository r_especialistas;	
	
	@Override
	public List<Especialista> listarTodos() {
		return r_especialistas.findAll();
	}

	@Override
	public Especialista buscar(int id) {
		Optional<Especialista> e_buscado = r_especialistas.findById(id);
		if(e_buscado.isPresent()) {
			return e_buscado.get();
		}else {
			return new Especialista();
		}
	}

	@Override
	public Especialista agregar(Especialista e_nuevo) {
		return r_especialistas.save(e_nuevo);
	}
	
	@Override
	public Especialista modificar(int id, Especialista e_cambiar) {
		Optional<Especialista> e_buscado = r_especialistas.findById(id);
		if(e_buscado.isPresent()) {
			e_cambiar.setEspecialistaId(id);
			return r_especialistas.save(e_cambiar);
		} else {
			return new Especialista();
		}
	}

	@Override
	public boolean eliminar(int id) {
		Optional<Especialista> e_buscado = r_especialistas.findById(id);
		if(e_buscado.isPresent()) {
			r_especialistas.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
