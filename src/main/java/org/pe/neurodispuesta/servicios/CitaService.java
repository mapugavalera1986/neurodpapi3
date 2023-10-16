package org.pe.neurodispuesta.servicios;

import java.util.LinkedList;
import java.util.List;

import org.pe.neurodispuesta.mapeados.CitaMapeados;
import org.pe.neurodispuesta.mapeados.EspecialistaMapeados;
import org.pe.neurodispuesta.mapeados.ParticipanteMapeados;
import org.pe.neurodispuesta.modelos.Cita;
import org.pe.neurodispuesta.repositorios.ICitaRepository;
import org.pe.neurodispuesta.transferencias.CitaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
	
	@Autowired
	private ICitaRepository r_citas;

	@Autowired
	private CitaMapeados mp_citas;
	
	@Autowired
	private EspecialistaMapeados mp_especialistas;
	
	@Autowired
	private ParticipanteMapeados mp_participantes;
	
	public List<CitaDto> listar(){
		List<Cita> l_sin_procesar = r_citas.findAll();
		List<CitaDto> l_procesada = new LinkedList<CitaDto>();
		for(Cita c : l_sin_procesar) {
			CitaDto cp = mp_citas.crearDto(c);
			cp.setParticipante(mp_participantes.crearDto(c.getParticipante()));
			cp.setEspecialista(mp_especialistas.crearDto(c.getEspecialista()));
			l_procesada.add(cp);
		}
		return l_procesada;
	}
	
	public CitaDto buscar(int id) {
		Cita c_buscada = r_citas.findById(id).get();
		CitaDto c_procesada = mp_citas.crearDto(c_buscada);
		c_procesada.setParticipante(mp_participantes.crearDto(c_buscada.getParticipante()));
		c_procesada.setEspecialista(mp_especialistas.crearDto(c_buscada.getEspecialista()));
		return c_procesada;
	}
	
	public CitaDto agregar(CitaDto ingresar_c) {
		ingresar_c.setCitaId(0);
		Cita egresar = mp_citas.convertir(ingresar_c);
		egresar.setParticipante(mp_participantes.convertir(ingresar_c.getParticipante()));
		egresar.setEspecialista(mp_especialistas.convertir(ingresar_c.getEspecialista()));
		return mp_citas.crearDto(r_citas.saveAndFlush(egresar));
	}
	
	public CitaDto modificar(int id, CitaDto modificar_c) throws Exception {
		if(r_citas.findById(id).isPresent()) {
			modificar_c.setCitaId(id);
			Cita egresar = mp_citas.convertir(modificar_c);
			egresar.setParticipante(mp_participantes.convertir(modificar_c.getParticipante()));
			egresar.setEspecialista(mp_especialistas.convertir(modificar_c.getEspecialista()));
			return mp_citas.crearDto(r_citas.saveAndFlush(egresar));
		} else {
			throw new IllegalArgumentException("Necesitas un ID para su modificación");
		}
	}
	
	public boolean eliminar(int id) {
		if(r_citas.findById(id).isPresent()) {
			r_citas.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
