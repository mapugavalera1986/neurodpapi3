package org.pe.neurodispuesta.mapeados;

import java.util.LinkedList;
import java.util.List;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.transferencias.CompletoCddrDto;
import org.pe.neurodispuesta.transferencias.SimplePrtcDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuidadorMapeadosCompletos {
	
	@Autowired
	private ParticipanteMapeadosSimples mp_participantes;
	
	public CompletoCddrDto crearDto(Cuidador ingresar_c) {
		List<SimplePrtcDto>l_participantes = new LinkedList<SimplePrtcDto>();
		CompletoCddrDto egreso_cc = new CompletoCddrDto();
		for(Participante p: ingresar_c.getParticipantes()){
			l_participantes.add(mp_participantes.crearDto(p));
		}
		BeanUtils.copyProperties(ingresar_c, egreso_cc);
		egreso_cc.setParticipantes(l_participantes);
		return egreso_cc;
	}
}
