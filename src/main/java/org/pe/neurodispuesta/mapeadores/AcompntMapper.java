package org.pe.neurodispuesta.mapeadores;

import java.util.Optional;

import org.pe.neurodispuesta.modelos.Acompnt;
import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.transferencias.AcompntDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AcompntMapper {
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private IEspecialistaRepository r_especialistas;
	
	public AcompntDTO crearDto(Acompnt ing_acpn) {
		AcompntDTO cambio = new AcompntDTO();
		cambio.setAcompntId(ing_acpn.getAcompntId());
		cambio.setFechaRegistro(ing_acpn.getFechaRegistro());
		cambio.setParticipanteId(ing_acpn.getParticipante().getParticipanteId());
		cambio.setEspecialistaId(ing_acpn.getEspecialista().getEspecialistaId());
		cambio.setActivo(ing_acpn.isActivo());
		return cambio;
	}
	
	public Acompnt crearEntidad(AcompntDTO ing_acpt) {
		Acompnt cambio = new Acompnt();
		cambio.setAcompntId(ing_acpt.getAcompntId());
		cambio.setFechaRegistro(ing_acpt.getFechaRegistro());
		Optional<Participante> prtc = r_participantes.findById(ing_acpt.getParticipanteId());
		cambio.setParticipante(prtc.get());
		Optional<Especialista> espc = r_especialistas.findById(ing_acpt.getParticipanteId());
		cambio.setEspecialista(espc.get());
		cambio.setActivo(ing_acpt.isActivo());
		return cambio;
	}
}
