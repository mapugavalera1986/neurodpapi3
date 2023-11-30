package org.pe.neurodispuesta.mapeador;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.transferencia.CuidadorDto;
import org.springframework.stereotype.Component;

@Component
public class CuidadorMapper {
	
	public CuidadorDto volverDto(Cuidador ingresar) {
		CuidadorDto egresar = new CuidadorDto();
		egresar.setCuidadorId(ingresar.getCuidadorId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		return egresar;
	}
	
	public Cuidador volverEntidad(CuidadorDto ingresar) {
		Cuidador egresar = new Cuidador();
		egresar.setCuidadorId(ingresar.getCuidadorId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		return egresar;
	}
}
