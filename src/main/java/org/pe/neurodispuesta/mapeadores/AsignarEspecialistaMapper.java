package org.pe.neurodispuesta.mapeadores;

import java.text.ParseException;
import java.util.Optional;

import org.pe.neurodispuesta.modelos.Asignar;
import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.transferencias.AsignarEspecialistaDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class AsignarEspecialistaMapper {
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private IEspecialistaRepository  r_especialistas;
	
	public AsignarEspecialistaDTO crearDto(Asignar ing_asgn) {
		AsignarEspecialistaDTO cambio = new AsignarEspecialistaDTO();
		cambio.setAsignarId(ing_asgn.getAsignarId());
		cambio.setParticipanteId(ing_asgn.getParticipante().getParticipanteId());
		cambio.setEspecialistaId(ing_asgn.getEspecialista().getEspecialistaId());
		cambio.setFechaEstablecimiento(ing_asgn.getFechaEstablecimiento());
		cambio.setActiva(ing_asgn.isActiva());
		return cambio;	
	}
	
	public Asignar crearEntidad(AsignarEspecialistaDTO ing_asgt,
			Participante n_prtc, Especialista n_espc) throws ParseException{
		Asignar cambio = new Asignar();
		cambio.setAsignarId(ing_asgt.getAsignarId());
		cambio.setParticipante(n_prtc);
		cambio.setEspecialista(n_espc);
		cambio.setFechaEstablecimiento(ing_asgt.getFechaEstablecimiento());
		cambio.setActiva(ing_asgt.isActiva());
		return cambio;	
	}
	
	public Asignar crearEntidad(AsignarEspecialistaDTO ing_asgt)
			throws ParseException{
		Asignar cambio = new Asignar();
		cambio.setAsignarId(ing_asgt.getAsignarId());
		Optional<Participante> n_prtc= r_participantes.findById(ing_asgt.getParticipanteId());
		cambio.setParticipante(n_prtc.get());
		Optional<Especialista> n_espc= r_especialistas.findById(ing_asgt.getEspecialistaId());
		cambio.setEspecialista(n_espc.get());
		cambio.setFechaEstablecimiento(ing_asgt.getFechaEstablecimiento());
		cambio.setActiva(ing_asgt.isActiva());
		return cambio;	
	}
}
