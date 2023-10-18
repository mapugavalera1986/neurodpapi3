package org.pe.neurodispuesta.mapeadores;

import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.transferencias.EspecialistaDTO;
import org.springframework.stereotype.Component;

@Component
public class EspecialistaMapper {

	public EspecialistaDTO crearDto(Especialista ing_espc) {
		EspecialistaDTO cambio = new EspecialistaDTO();
		cambio.setEspecialistaId(ing_espc.getEspecialistaId());
		cambio.setNmbrs(ing_espc.getNmbrs());
		cambio.setApllds(ing_espc.getApllds());
		cambio.setDni(ing_espc.getDni());
		cambio.setRuc(ing_espc.getRuc());
		cambio.setCorreoE(ing_espc.getCorreoE());
		cambio.setFechaIngreso(ing_espc.getFechaIngreso());
		cambio.setTelf(ing_espc.getTelf());
		cambio.setActivo(ing_espc.isActivo());
		return cambio;
	}
	
	public Especialista crearEntidad(EspecialistaDTO ing_espt) {
		Especialista cambio = new Especialista();
		cambio.setEspecialistaId(ing_espt.getEspecialistaId());
		cambio.setNmbrs(ing_espt.getNmbrs());
		cambio.setApllds(ing_espt.getApllds());
		cambio.setDni(ing_espt.getDni());
		cambio.setRuc(ing_espt.getRuc());
		cambio.setCorreoE(ing_espt.getCorreoE());
		cambio.setFechaIngreso(ing_espt.getFechaIngreso());
		cambio.setTelf(ing_espt.getTelf());
		cambio.setActivo(ing_espt.isActivo());
		return cambio;
	}
}
