package org.pe.neurodispuesta.servicios.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeadores.CuidadorMapper;
import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.servicios.ICuidadorService;
import org.pe.neurodispuesta.transferencias.CuidadorDTO;
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
	
	@Autowired
	private CuidadorMapper mp_cuidadores;
	
	@Override
	public List<CuidadorDTO> listarTodos() {
		List<Cuidador> l_parcial = r_cuidadores.findAll();
		return l_parcial.stream().map(mp_cuidadores::crearDto).collect(Collectors.toList());
	}

	@Override
	public CuidadorDTO buscar(int id) {
		return mp_cuidadores.crearDto(r_cuidadores.findById(id).get());
	}

	@Override
	public CuidadorDTO agregar(CuidadorDTO c_nuevo) {
		Cuidador c_procesado = mp_cuidadores.crearEntidad(c_nuevo);
		return mp_cuidadores.crearDto(r_cuidadores.save(c_procesado));
	}

	@Override
	public CuidadorDTO modificar(int id, CuidadorDTO c_cambiar) {
		Optional<Cuidador> c_encontrado = r_cuidadores.findById(id);
		if(c_encontrado.isPresent()) {
			Cuidador p_procesado = c_encontrado.get();
			p_procesado.setNmbrs(c_cambiar.getNmbrs());
			p_procesado.setApllds(c_cambiar.getApllds());
			p_procesado.setDni(c_cambiar.getDni());
			p_procesado.setCorreoE(c_cambiar.getCorreoE());
			p_procesado.setTelf(c_cambiar.getTelf());
			return mp_cuidadores.crearDto(r_cuidadores.saveAndFlush(p_procesado));
		} else {
			return null;
		}
	}

	@Override
	public void eliminar(int id) {
		Optional<Cuidador> p_eliminado = r_cuidadores.findById(id);
		if(p_eliminado.isPresent()) {
			for(Participante p : p_eliminado.get().getParticipantes()) {
				r_participantes.deleteById(p.getParticipanteId());
			}
			r_cuidadores.deleteById(id);
		}
	}

}
