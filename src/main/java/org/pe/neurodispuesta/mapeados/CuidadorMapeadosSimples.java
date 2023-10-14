package org.pe.neurodispuesta.mapeados;

import java.util.Optional;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.transferencias.SimpleCddrDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CuidadorMapeadosSimples {
		
	public SimpleCddrDto crearDtoSeguro(Optional<Cuidador> ingreso_c) {
		SimpleCddrDto egreso_sc = new SimpleCddrDto();
		BeanUtils.copyProperties(ingreso_c, egreso_sc);
		return egreso_sc;
	}
	
	public SimpleCddrDto crearDto(Cuidador ingreso_c) {
		SimpleCddrDto egreso_sc = new SimpleCddrDto();
		BeanUtils.copyProperties(ingreso_c, egreso_sc);
		return egreso_sc;
	}
	
	public Cuidador convertir(SimpleCddrDto ingreso_c) {
		Cuidador egreso_c = new Cuidador();
		BeanUtils.copyProperties(ingreso_c, egreso_c);
		return egreso_c;
	}
}
