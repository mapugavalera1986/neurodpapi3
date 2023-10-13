package org.pe.neurodispuesta.mapeados;

import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.transferencias.SimplePrtcDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteMapeadosSimples {

	public SimplePrtcDto crearDto(Participante ingresar_p) {
		SimplePrtcDto egreso_sp = new SimplePrtcDto();
		BeanUtils.copyProperties(ingresar_p, egreso_sp);
		return egreso_sp;
	}
	
	public Participante convertir(SimplePrtcDto ingresar_sp) {
		Participante egreso_p = new Participante();
		BeanUtils.copyProperties(ingresar_sp, egreso_p);
		return egreso_p;
	}
}
