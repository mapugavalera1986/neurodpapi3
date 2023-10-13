package org.pe.neurodispuesta.mapeados;

import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.transferencias.CompletoPrtcDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteMapeadosCompletos {
	
	@Autowired
	private CuidadorMapeadosSimples mp_cuidadores;
	
	public CompletoPrtcDto crearDto(Participante ingresar_p) {
		CompletoPrtcDto egreso_cp = new CompletoPrtcDto();
		BeanUtils.copyProperties(ingresar_p, egreso_cp);
		egreso_cp.setCuidador(mp_cuidadores.crearDto(ingresar_p.getCuidador()));
		return egreso_cp;
	}
}
