package org.pe.neurodispuesta.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.servicios.ICuidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CuidadorServiceImpl implements ICuidadorService{
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	
	@Override
	public List<Cuidador> listarTodos() {
		return r_cuidadores.findAll();
	}

	@Override
	public Cuidador buscar(int id) {
		Optional<Cuidador> c_buscado = r_cuidadores.findById(id);
		if(c_buscado.isPresent()) {
			return c_buscado.get();
		}else {
			return new Cuidador();
		}
	}

	@Override
	public Cuidador agregar(Cuidador c_nuevo) {
		return r_cuidadores.save(c_nuevo);
	}
	
	@Override
	public Cuidador modificar(int id, Cuidador c_cambiar) {
		Optional<Cuidador> c_buscado = r_cuidadores.findById(id);
		if(c_buscado.isPresent()) {
			c_cambiar.setCuidadorId(id);
			return r_cuidadores.save(c_cambiar);
		} else {
			return new Cuidador();
		}
	}

	@Override
	public void eliminar(int id) {
		Optional<Cuidador> c_buscado = r_cuidadores.findById(id);
		if(c_buscado.isPresent()) {
			for(Participante p : c_buscado.get().getParticipantes()) {
				r_participantes.deleteById(p.getParticipanteId());
			}
			r_cuidadores.deleteById(id);
		}
	}
}
