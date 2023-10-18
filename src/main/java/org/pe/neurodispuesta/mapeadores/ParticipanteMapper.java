package org.pe.neurodispuesta.mapeadores;

import java.text.ParseException;
import java.util.Optional;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.transferencias.ParticipanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipanteMapper {
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	public ParticipanteDTO crearDto(Participante ing_prtc) {
		ParticipanteDTO cambio = new ParticipanteDTO();
		cambio.setParticipanteId(ing_prtc.getParticipanteId());
		cambio.setNmbrs(ing_prtc.getNmbrs());
		cambio.setApllds(ing_prtc.getApllds());
		cambio.setDni(ing_prtc.getDni());
		cambio.setCorreoE(ing_prtc.getCorreoE());
		cambio.setTelf(ing_prtc.getTelf());
		cambio.setFechaRegistro(ing_prtc.getFechaRegistro());
		cambio.setCuidadorId(ing_prtc.getCuidador().getCuidadorId());
		return cambio;
	}
	
	public Participante crearEntidad(ParticipanteDTO ing_prtt, Cuidador n_cddr)
			throws ParseException {
		Participante cambio = new Participante();
		cambio.setParticipanteId(ing_prtt.getParticipanteId());
		cambio.setNmbrs(ing_prtt.getNmbrs());
		cambio.setApllds(ing_prtt.getApllds());
		cambio.setDni(ing_prtt.getDni());
		cambio.setCorreoE(ing_prtt.getCorreoE());
		cambio.setTelf(ing_prtt.getTelf());
		cambio.setFechaRegistro(ing_prtt.getFechaRegistro());
		cambio.setCuidador(n_cddr);
		return cambio;
	}
	
	public Participante crearEntidad(ParticipanteDTO ing_prtt) throws ParseException {
		Participante cambio = new Participante();
		cambio.setParticipanteId(ing_prtt.getParticipanteId());
		cambio.setNmbrs(ing_prtt.getNmbrs());
		cambio.setApllds(ing_prtt.getApllds());
		cambio.setDni(ing_prtt.getDni());
		cambio.setCorreoE(ing_prtt.getCorreoE());
		cambio.setTelf(ing_prtt.getTelf());
		cambio.setFechaRegistro(ing_prtt.getFechaRegistro());
		Optional <Cuidador> n_cddr = r_cuidadores.findById(ing_prtt.getCuidadorId());
		cambio.setCuidador(n_cddr.get());
		return cambio;
	}
}
