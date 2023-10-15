package org.pe.neurodispuesta.mapeados;

import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.transferencias.PrtcDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteMapeados {
		
	public PrtcDto crearDto(Participante ingresar_p) {
		PrtcDto egreso_sp = new PrtcDto();
		BeanUtils.copyProperties(ingresar_p, egreso_sp);
		return egreso_sp;
	}
	
	public Participante convertir(PrtcDto ingresar_sp) {
		Participante egreso_p = new Participante();
		BeanUtils.copyProperties(ingresar_sp, egreso_p);
		return egreso_p;
	}
}
