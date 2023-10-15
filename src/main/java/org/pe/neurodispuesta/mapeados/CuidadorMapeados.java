package org.pe.neurodispuesta.mapeados;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.transferencias.CddrDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CuidadorMapeados {
		
	public CddrDto crearDto(Cuidador ingresar_c) {
		CddrDto egreso_sc = new CddrDto();
		BeanUtils.copyProperties(ingresar_c, egreso_sc);
		return egreso_sc;
	}
	
	public Cuidador convertir(CddrDto ingresar_sc) {
		Cuidador egreso_c = new Cuidador();
		BeanUtils.copyProperties(ingresar_sc, egreso_c);
		return egreso_c;
	}
}
