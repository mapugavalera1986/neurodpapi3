package org.pe.neurodispuesta.mapeadores;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.transferencias.CuidadorDTO;
import org.springframework.stereotype.Component;

@Component
public class CuidadorMapper {
	
	public CuidadorDTO crearDto(Cuidador ing_cddr) {
		CuidadorDTO cambio = new CuidadorDTO();
		cambio.setCuidadorId(ing_cddr.getCuidadorId());
		cambio.setNmbrs(ing_cddr.getNmbrs());
		cambio.setApllds(ing_cddr.getApllds());
		cambio.setDni(ing_cddr.getDni());
		cambio.setCorreoE(ing_cddr.getCorreoE());
		cambio.setTelf(ing_cddr.getTelf());
		return cambio;
	}
	
	public Cuidador crearEntidad(CuidadorDTO ing_cddt) {
		Cuidador cambio = new Cuidador();
		cambio.setCuidadorId(ing_cddt.getCuidadorId());
		cambio.setNmbrs(ing_cddt.getNmbrs());
		cambio.setApllds(ing_cddt.getApllds());
		cambio.setDni(ing_cddt.getDni());
		cambio.setCorreoE(ing_cddt.getCorreoE());
		cambio.setTelf(ing_cddt.getTelf());
		return cambio;
	}
}
