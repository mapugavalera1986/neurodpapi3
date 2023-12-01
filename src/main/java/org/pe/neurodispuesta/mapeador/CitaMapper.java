package org.pe.neurodispuesta.mapeador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.pe.neurodispuesta.modelos.Cita;
import org.pe.neurodispuesta.modelos.EstadoCita;
import org.pe.neurodispuesta.modelos.ModalidadCita;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.transferencia.CitaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private IEspecialistaRepository r_especialistas;

	public CitaDto volverDto(Cita ingresar) {
		CitaDto egresar = new CitaDto();
		egresar.setCitaId(ingresar.getCitaId());
		egresar.setFecha(ingresar.getFecha().toString());
		egresar.setParticipanteId(ingresar.getParticipante().getParticipanteId());
		egresar.setEspecialistaId(ingresar.getEspecialista().getEspecialistaId());
		egresar.setModalidadCita(ingresar.getModalidadCita().name());
		egresar.setEstadoCita(ingresar.getEstadoCita().name());
		return egresar;
	}
	
	public Cita volverEntidad(CitaDto ingresar) {
		Cita egresar = new Cita();
		egresar.setCitaId(ingresar.getCitaId());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha_registro = LocalDate.parse(ingresar.getFecha(),formatter);
		egresar.setFecha(fecha_registro);
		egresar.setParticipante(r_participantes.findById(ingresar.getParticipanteId()).get());
		egresar.setEspecialista(r_especialistas.findById(ingresar.getEspecialistaId()).get());
		egresar.setModalidadCita(ModalidadCita.valueOf(ingresar.getModalidadCita()));
		egresar.setEstadoCita(EstadoCita.valueOf(ingresar.getModalidadCita()));
		return egresar;
	}
}
