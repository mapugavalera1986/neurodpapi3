package org.pe.neurodispuesta.mapeador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.transferencia.ParticipanteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipanteMapper {
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	public ParticipanteDto volverDto(Participante ingresar) {
		ParticipanteDto egresar = new ParticipanteDto();
		egresar.setParticipanteId(ingresar.getParticipanteId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		egresar.setFechaRegistro(ingresar.getFechaRegistro().toString());
		egresar.setCuidadorId(ingresar.getCuidador().getCuidadorId());
		return egresar;
	}
	
	public Participante volverEntidad(ParticipanteDto ingresar) {
		Participante egresar = new Participante();
		egresar.setParticipanteId(ingresar.getParticipanteId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate fecha_registro = LocalDate.parse(ingresar.getFechaRegistro(), formatter);
		egresar.setFechaRegistro(fecha_registro);
		egresar.setCuidador(r_cuidadores.findById(ingresar.getCuidadorId()).get());
		return egresar;
	}
}
