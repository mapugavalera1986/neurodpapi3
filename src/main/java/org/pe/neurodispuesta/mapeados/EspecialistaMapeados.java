package org.pe.neurodispuesta.mapeados;

import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.transferencias.EspcDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EspecialistaMapeados {

	public EspcDto crearDto(Especialista ingresar_e) {
		EspcDto egreso_se  = new EspcDto();
		BeanUtils.copyProperties(ingresar_e, egreso_se);
		return egreso_se;
	}
	
	public Especialista convertir(EspcDto ingresar_se) {
		Especialista egreso_e = new Especialista();
		BeanUtils.copyProperties(ingresar_se, egreso_e);
		return egreso_e;
	}
}
