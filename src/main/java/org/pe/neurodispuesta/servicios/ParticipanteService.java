package org.pe.neurodispuesta.servicios;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeadores.ParticipanteMapper;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.transferencias.ParticipanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	@Autowired
	private ParticipanteMapper mp_participantes;

	public List<ParticipanteDTO> listarTodos(){
		List<Participante> l_parcial = r_participantes.findAll();
		return l_parcial.stream().map(mp_participantes::crearDto).collect(Collectors.toList());
	}
	
	public Optional<ParticipanteDTO> buscar(int id){
		Optional<Participante> p_buscado = r_participantes.findById(id);
		return p_buscado.map(mp_participantes::crearDto);
	}
	
	public ParticipanteDTO agregar(ParticipanteDTO p_nuevo) throws ParseException {
		Participante p_procesado = mp_participantes.crearEntidad(p_nuevo);
		return mp_participantes.crearDto(r_participantes.saveAndFlush(p_procesado));
	}
	
	public ParticipanteDTO modificar(int id, ParticipanteDTO p_cambiar) {
		Optional<Participante> p_encontrado = r_participantes.findById(id);
		if(p_encontrado.isPresent()) {
			Participante p_procesado = p_encontrado.get();
			p_procesado.setNmbrs(p_cambiar.getNmbrs());
			p_procesado.setApllds(p_cambiar.getApllds());
			p_procesado.setDni(p_cambiar.getDni());
			p_procesado.setCorreoE(p_cambiar.getCorreoE());
			p_procesado.setTelf(p_cambiar.getTelf());
			p_procesado.setFechaRegistro(p_cambiar.getFechaRegistro());
			p_procesado.setCuidador(r_cuidadores.findById(p_cambiar.getCuidadorId()).get());
			return mp_participantes.crearDto(r_participantes.saveAndFlush(p_procesado));
		} else {
			return null;
		}
	}
	
	public void eliminar(int id) {
		Optional<Participante> p_eliminado = r_participantes.findById(id);
		if(p_eliminado.isPresent()) {
			r_participantes.deleteById(id);
		}
	}
}
