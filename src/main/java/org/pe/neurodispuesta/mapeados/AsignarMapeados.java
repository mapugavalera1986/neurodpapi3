package org.pe.neurodispuesta.mapeados;

import org.pe.neurodispuesta.modelos.Asignar;
import org.pe.neurodispuesta.transferencias.AsgnDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignarMapeados {

	@Autowired
	private ParticipanteMapeados mp_participantes;
	public AsgnDto crearDto(Asignar ingresar_a) {
		AsgnDto egreso_sa = new AsgnDto();
		egreso_sa.setEspecialista(null);
		return egreso_sa;
	}
	
	public Asignar convertir(AsgnDto ingresar_sa) {
		Asignar egreso_a = new Asignar();
		BeanUtils.copyProperties(ingresar_sa, egreso_a);
		return egreso_a;
	}
}
