package org.pe.neurodispuesta.servicios;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeadores.AsignarEspecialistaMapper;
import org.pe.neurodispuesta.mapeadores.CuidadorMapper;
import org.pe.neurodispuesta.mapeadores.ParticipanteMapper;
import org.pe.neurodispuesta.modelos.Asignar;
import org.pe.neurodispuesta.repositorios.IAsignarRepository;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.transferencias.AsignarEspecialistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignarService {
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	@Autowired
	private IEspecialistaRepository r_especialistas;
	
	@Autowired
	private IAsignarRepository r_asignaciones;
	
	@Autowired
	private ParticipanteMapper mp_participantes;
	
	@Autowired
	private CuidadorMapper mp_cuidadores;
	
	@Autowired
	private AsignarEspecialistaMapper mp_asignaciones;

	public List<AsignarEspecialistaDTO> listarTodos(){
		List<Asignar> l_parcial = r_asignaciones.findAll();
		return l_parcial.stream().map(mp_asignaciones::crearDto).collect(Collectors.toList());
	}
	
	public Optional<AsignarEspecialistaDTO> buscar(int id){
		Optional<Asignar> p_buscado = r_asignaciones.findById(id);
		return p_buscado.map(mp_asignaciones::crearDto);
	}
	
	public AsignarEspecialistaDTO agregar(AsignarEspecialistaDTO p_nuevo) throws ParseException {
		Asignar p_procesado = mp_asignaciones.crearEntidad(p_nuevo);
		return mp_asignaciones.crearDto(r_asignaciones.saveAndFlush(p_procesado));
	}
	
	public AsignarEspecialistaDTO modificar(int id, AsignarEspecialistaDTO p_cambiar) {
		Optional<Asignar> p_encontrado = r_asignaciones.findById(id);
		if(p_encontrado.isPresent()) {
			Asignar p_procesado = p_encontrado.get();
			p_procesado.setParticipante(r_participantes.findById(p_cambiar.getParticipanteId()).get());
			p_procesado.setEspecialista(r_especialistas.findById(p_cambiar.getEspecialistaId()).get());
			p_procesado.setFechaEstablecimiento(p_cambiar.getFechaEstablecimiento());
			p_procesado.setActiva(p_cambiar.isActiva());
			return mp_asignaciones.crearDto(r_asignaciones.saveAndFlush(p_procesado));
		} else {
			return null;
		}
	}
	
	public void eliminar(int id) {
		Optional<Asignar> p_eliminado = r_asignaciones.findById(id);
		if(p_eliminado.isPresent()) {
			r_asignaciones.deleteById(id);
		}
	}
}
