package org.pe.neurodispuesta.mapeados;

import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.transferencias.SimpleEspcDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EspecialistaMapeadosSimples {

	public SimpleEspcDto crearDto(Especialista ingresar_e) {
		SimpleEspcDto egreso_se  = new SimpleEspcDto();
		BeanUtils.copyProperties(ingresar_e, egreso_se);
		return egreso_se;
	}
	
	public Especialista convertir(SimpleEspcDto ingresar_se) {
		Especialista egreso_e = new Especialista();
		return egreso_e;
	}
}
