package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeados.CuidadorMapeados;
import org.pe.neurodispuesta.mapeados.ParticipanteMapeados;
import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.transferencias.CddrDto;
import org.pe.neurodispuesta.transferencias.PrtcDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuidadorService {
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	@Autowired
	private CuidadorMapeados mp_cuidadores;
	
	@Autowired
	private ParticipanteMapeados mp_participantes;
	
	public List<CddrDto> listar(){
		List<Cuidador> l_sin_procesar = r_cuidadores.findAll();
		List<CddrDto> l_procesada = l_sin_procesar.stream()
			.map(c -> mp_cuidadores.crearDto(c))
			.collect(Collectors.toList());
		return l_procesada;
	}
	
	public CddrDto buscar(int id) {
		Cuidador c_buscado = r_cuidadores.findById(id).get();
		CddrDto c_procesado = mp_cuidadores.crearDto(c_buscado);
		List<PrtcDto> l_parts = c_buscado.getParticipantes().stream()
			.map(p -> mp_participantes.crearDto(p))
			.collect(Collectors.toList());
		c_procesado.setParticipantes(l_parts);
		return c_procesado;
	}
}
