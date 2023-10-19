package org.pe.neurodispuesta.mapeadores;

import java.text.ParseException;
import java.util.Optional;

import org.pe.neurodispuesta.modelos.Acompnt;
import org.pe.neurodispuesta.modelos.Cita;
import org.pe.neurodispuesta.modelos.EstadoCita;
import org.pe.neurodispuesta.modelos.ModalidadCita;
import org.pe.neurodispuesta.repositorios.IAcompntRepository;
import org.pe.neurodispuesta.transferencias.CitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {
	
	@Autowired
	private IAcompntRepository r_acompnts;
	
	public CitaDTO crearDto(Cita ing_cita) {
		CitaDTO cambio = new CitaDTO();
		cambio.setCitaId(ing_cita.getCitaId());
		cambio.setFecha(ing_cita.getFecha());
		cambio.setAcompnt_id(ing_cita.getAcompnt().getAcompntId());
		cambio.setModalidadCita(ing_cita.getModalidadCita().name());
		cambio.setEstadoCita(ing_cita.getEstadoCita().name());
		return cambio;
	}
	
	public Cita crearEntidad(CitaDTO ing_citt) throws ParseException{
		Cita cambio = new Cita();
		cambio.setCitaId(ing_citt.getCitaId());
		cambio.setFecha(ing_citt.getFecha());
		Optional<Acompnt> acompnt = r_acompnts.findById(ing_citt.getAcompnt_id());
		cambio.setAcompnt(acompnt.get());
		cambio.setModalidadCita(ModalidadCita.valueOf(ing_citt.getEstadoCita()));
		cambio.setEstadoCita(EstadoCita.valueOf(ing_citt.getEstadoCita()));
		return cambio;
	}
	
	public Cita crearEntidad(CitaDTO ing_citt, Acompnt quienes) throws ParseException{
		Cita cambio = new Cita();
		cambio.setCitaId(ing_citt.getCitaId());
		cambio.setFecha(ing_citt.getFecha());
		cambio.setAcompnt(quienes);
		cambio.setModalidadCita(ModalidadCita.valueOf(ing_citt.getEstadoCita()));
		cambio.setEstadoCita(EstadoCita.valueOf(ing_citt.getEstadoCita()));
		return cambio;
	}
}
