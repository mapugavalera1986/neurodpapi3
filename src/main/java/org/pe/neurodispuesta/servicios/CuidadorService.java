package org.pe.neurodispuesta.servicios;

import java.text.ParseException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeadores.CuidadorMapper;
import org.pe.neurodispuesta.mapeadores.ParticipanteMapper;
import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.transferencias.CuidadorDTO;
import org.pe.neurodispuesta.transferencias.ParticipanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuidadorService {
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private ParticipanteMapper mp_participantes;
	
	@Autowired
	private CuidadorMapper mp_cuidadores;
	
	public List<CuidadorDTO> listarTodos(){
		List<Cuidador> l_parcial = r_cuidadores.findAll();
		return l_parcial.stream().map(mp_cuidadores::crearDto).collect(Collectors.toList());
	}
	
	public Optional<CuidadorDTO> buscar(int id){
		Optional<Cuidador> p_buscado = r_cuidadores.findById(id);
		return p_buscado.map(mp_cuidadores::crearDto);
	}
	
	public CuidadorDTO agregar(CuidadorDTO p_nuevo) throws ParseException {
		Cuidador p_procesado = mp_cuidadores.crearEntidad(p_nuevo);
		return mp_cuidadores.crearDto(r_cuidadores.saveAndFlush(p_procesado));
	}
	
	public CuidadorDTO modificar(int id, CuidadorDTO p_cambiar) {
		Optional<Cuidador> p_encontrado = r_cuidadores.findById(id);
		if(p_encontrado.isPresent()) {
			Cuidador p_procesado = p_encontrado.get();
			p_procesado.setNmbrs(p_cambiar.getNmbrs());
			p_procesado.setApllds(p_cambiar.getApllds());
			p_procesado.setDni(p_cambiar.getDni());
			p_procesado.setCorreoE(p_cambiar.getCorreoE());
			p_procesado.setTelf(p_cambiar.getTelf());
			return mp_cuidadores.crearDto(r_cuidadores.saveAndFlush(p_procesado));
		} else {
			return null;
		}
	}
	
	public void eliminar(int id) {
		Optional<Cuidador> p_eliminado = r_cuidadores.findById(id);
		if(p_eliminado.isPresent()) {
			for(Participante p : p_eliminado.get().getParticipantes()) {
				r_participantes.deleteById(p.getParticipanteId());
			}
			r_cuidadores.deleteById(id);
		}
	}
	
	public List<ParticipanteDTO> listar_participantes(int cuidadorInt){
		Optional<Cuidador> p_asignado = r_cuidadores.findById(cuidadorInt);
		return p_asignado.map(p -> p.getParticipantes().stream()
				.map(mp_participantes::crearDto)
				.collect(Collectors.toList()))
				.orElse(null);
	}
}
