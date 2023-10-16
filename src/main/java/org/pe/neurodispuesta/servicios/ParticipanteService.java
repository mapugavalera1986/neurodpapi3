package org.pe.neurodispuesta.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeados.CuidadorMapeados;
import org.pe.neurodispuesta.mapeados.ParticipanteMapeados;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.transferencias.PrtcDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private ParticipanteMapeados mp_participantes;
	
	@Autowired
	private CuidadorMapeados mp_cuidadores;
	
	public List<PrtcDto> listar(){
		List<Participante> l_sin_procesar = r_participantes.findAll();
		List<PrtcDto> l_procesada = l_sin_procesar.stream()
			.map(c -> mp_participantes.crearDto(c))
			.collect(Collectors.toList());
		return l_procesada;
	}
	
	public PrtcDto buscar(int id) {
		Participante p_buscado = r_participantes.findById(id).get();
		PrtcDto p_procesado = mp_participantes.crearDto(p_buscado);
		p_procesado.setCuidador(mp_cuidadores.crearDto(p_buscado.getCuidador()));
		return p_procesado;
	}
	
	public PrtcDto agregar(PrtcDto ingresar_p) {
		ingresar_p.setParticipanteId(0);
		Participante egresar = mp_participantes.convertir(ingresar_p);
		egresar.setCuidador(mp_cuidadores.convertir(ingresar_p.getCuidador()));
		return mp_participantes.crearDto(r_participantes.saveAndFlush(egresar));
	}
	
	public PrtcDto modificar(int id, PrtcDto modificar_p) throws Exception {
		if(r_participantes.findById(id).isPresent()) {
			modificar_p.setParticipanteId(id);
			Participante egresar = mp_participantes.convertir(modificar_p);
			egresar.setCuidador(mp_cuidadores.convertir(modificar_p.getCuidador()));
			return mp_participantes.crearDto(r_participantes.saveAndFlush(egresar));
		} else {
			throw new IllegalArgumentException("Necesitas un ID para su modificación");
		}
	}
	
	public boolean eliminar(int id) {
		if(r_participantes.findById(id).isPresent()) {
			r_participantes.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
