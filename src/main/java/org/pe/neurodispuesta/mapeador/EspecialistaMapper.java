package org.pe.neurodispuesta.mapeador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.transferencia.EspecialistaDto;
import org.springframework.stereotype.Component;

@Component
public class EspecialistaMapper {

	public EspecialistaDto volverDto(Especialista ingresar) {
		EspecialistaDto egresar = new EspecialistaDto();
		egresar.setEspecialistaId(ingresar.getEspecialistaId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setRuc(ingresar.getRuc());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		egresar.setFechaIngreso(ingresar.getFechaIngreso().toString());
		return egresar;
	}
	
	public Especialista volverEntidad(EspecialistaDto ingresar) {
		Especialista egresar = new Especialista();
		egresar.setEspecialistaId(ingresar.getEspecialistaId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setRuc(ingresar.getRuc());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDate fecha_registro = LocalDate.parse(ingresar.getFechaIngreso(),formatter);
		egresar.setFechaIngreso(fecha_registro);
		return egresar;
	}
}
