package org.pe.neurodispuesta.servicios;

import java.text.ParseException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeadores.AcompntMapper;
import org.pe.neurodispuesta.mapeadores.CitaMapper;
import org.pe.neurodispuesta.modelos.Acompnt;
import org.pe.neurodispuesta.modelos.Cita;
import org.pe.neurodispuesta.repositorios.IAcompntRepository;
import org.pe.neurodispuesta.repositorios.ICitaRepository;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.transferencias.AcompntDTO;
import org.pe.neurodispuesta.transferencias.CitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcompntService {
	
	@Autowired
	private IAcompntRepository r_acompnts;
	
	@Autowired
	private ICitaRepository r_citas;

	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private IEspecialistaRepository r_especialistas;
		
	@Autowired
	private AcompntMapper mp_acompnts;
	
	@Autowired
	private CitaMapper mp_citas;
	
	public List<AcompntDTO> listarTodos(){
		List<Acompnt> l_parcial = r_acompnts.findAll();
		return l_parcial.stream().map(mp_acompnts::crearDto).collect(Collectors.toList());
	}
	
	public Optional<AcompntDTO> buscar(int id){
		Optional<Acompnt> p_buscado = r_acompnts.findById(id);
		return p_buscado.map(mp_acompnts::crearDto);
	}
	
	public AcompntDTO agregar(AcompntDTO p_nuevo) throws ParseException {
		Acompnt p_procesado = mp_acompnts.crearEntidad(p_nuevo);
		return mp_acompnts.crearDto(r_acompnts.saveAndFlush(p_procesado));
	}
	
	public AcompntDTO modificar(int id, AcompntDTO p_cambiar) {
		Optional<Acompnt> p_encontrado = r_acompnts.findById(id);
		if(p_encontrado.isPresent()) {
			Acompnt p_procesado = p_encontrado.get();
			p_procesado.setFechaRegistro(p_cambiar.getFechaRegistro());
			p_procesado.setParticipante(r_participantes.findById(p_cambiar.getParticipanteId()).get());
			p_procesado.setEspecialista(r_especialistas.findById(p_cambiar.getEspecialistaId()).get());
			p_procesado.setActivo(p_cambiar.isActivo());
			return mp_acompnts.crearDto(r_acompnts.saveAndFlush(p_procesado));
		} else {
			return null;
		}
	}
	
	public void eliminar(int id) {
		Optional<Acompnt> p_eliminado = r_acompnts.findById(id);
		if(p_eliminado.isPresent()) {
			for(Cita c: p_eliminado.get().getCitas()) {
				r_citas.deleteById(c.getCitaId());
			}
			r_acompnts.deleteById(id);
		}
	}
	
	public void cambiarActivation(int id) {
		Optional<Acompnt> p_encontrado = r_acompnts.findById(id);
		if(p_encontrado.isPresent()) {
			Acompnt p_procesado = p_encontrado.get();
			p_procesado.setActivo(!p_procesado.isActivo());
		}
	}
	
	public List<CitaDTO> listar_citas(int acompntInt){
		Optional<Acompnt> p_asignado = r_acompnts.findById(acompntInt);
		return p_asignado.map(p -> p.getCitas().stream()
				.map(mp_citas::crearDto)
				.collect(Collectors.toList()))
				.orElse(null);
	}
}