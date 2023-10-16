package org.pe.neurodispuesta.mapeados;

import org.pe.neurodispuesta.modelos.Cita;
import org.pe.neurodispuesta.transferencias.CitaDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CitaMapeados {
		
	public CitaDto crearDto(Cita ingresar_c) {
		CitaDto egreso_sc = new CitaDto();
		BeanUtils.copyProperties(ingresar_c, egreso_sc);
		return egreso_sc;
	}
	
	public Cita convertir(CitaDto ingresar_sc) {
		Cita egreso_c = new Cita();
		BeanUtils.copyProperties(ingresar_sc, egreso_c);
		return egreso_c;
	}
}
