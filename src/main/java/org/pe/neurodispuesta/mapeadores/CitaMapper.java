package org.pe.neurodispuesta.mapeadores;

import java.text.ParseException;

import org.pe.neurodispuesta.modelos.Cita;
import org.pe.neurodispuesta.modelos.EstadoCita;
import org.pe.neurodispuesta.modelos.ModalidadCita;
import org.pe.neurodispuesta.repositorios.IAsignarRepository;
import org.pe.neurodispuesta.transferencias.CitaDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class CitaMapper {
	
	@Autowired
	private IAsignarRepository r_asignaciones;
	
	public CitaDTO crearDto(Cita ingreso) {
		CitaDTO egreso = new CitaDTO();
		egreso.setCitaId(ingreso.getCitaId());
		if(ingreso.getAsigna_especialista() != null) {
			egreso.setAsignarId(ingreso.getAsigna_especialista().getAsignarId());
		}
		egreso.setModalidadCita(ingreso.getModalidadCita().toString());
		egreso.setFecha(ingreso.getFecha());
		egreso.setEstadoCita(ingreso.getEstadoCita().toString());
		return egreso;
	}
	
	public Cita crearEntidad(CitaDTO ingreso) throws ParseException {
		Cita egreso = new Cita();
		egreso.setCitaId(ingreso.getCitaId());
		if(ingreso.getAsignarId() != 0) {
			egreso.setAsigna_especialista(r_asignaciones.findById(ingreso.getAsignarId()).get());
		}
		egreso.setModalidadCita(ModalidadCita.valueOf(ingreso.getModalidadCita()));
		egreso.setFecha(ingreso.getFecha());
		egreso.setEstadoCita(EstadoCita.valueOf(ingreso.getEstadoCita()));
		return egreso;
	}
}
