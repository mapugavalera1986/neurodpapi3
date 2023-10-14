package org.pe.neurodispuesta.mapeados;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.transferencias.SimpleCddrDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CuidadorMapeadosSimples {
		
	public SimpleCddrDto crearDto(Cuidador ingresar_c) {
		SimpleCddrDto egreso_sc = new SimpleCddrDto();
		BeanUtils.copyProperties(ingresar_c, egreso_sc);
		return egreso_sc;
	}
	
	public Cuidador convertir(SimpleCddrDto ingresar_sc) {
		Cuidador egreso_c = new Cuidador();
		BeanUtils.copyProperties(ingresar_sc, egreso_c);
		return egreso_c;
	}
}
