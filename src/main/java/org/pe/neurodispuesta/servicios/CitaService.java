package org.pe.neurodispuesta.servicios;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeadores.CitaMapper;
import org.pe.neurodispuesta.modelos.Cita;
import org.pe.neurodispuesta.modelos.EstadoCita;
import org.pe.neurodispuesta.modelos.ModalidadCita;
import org.pe.neurodispuesta.repositorios.IAcompntRepository;
import org.pe.neurodispuesta.repositorios.ICitaRepository;
import org.pe.neurodispuesta.transferencias.CitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
	
	@Autowired
	private IAcompntRepository r_acompnt;
	
	@Autowired
	private ICitaRepository r_citas;
		
	@Autowired
	private CitaMapper mp_citas;
	
	public List<CitaDTO> listarTodos(){
		List<Cita> l_parcial = r_citas.findAll();
		return l_parcial.stream().map(mp_citas::crearDto).collect(Collectors.toList());
	}
	
	public Optional<CitaDTO> buscar(int id){
		Optional<Cita> p_buscado = r_citas.findById(id);
		return p_buscado.map(mp_citas::crearDto);
	}
	
	public CitaDTO agregar(CitaDTO p_nuevo) throws ParseException {
		Cita p_procesado = mp_citas.crearEntidad(p_nuevo);
		return mp_citas.crearDto(r_citas.saveAndFlush(p_procesado));
	}
	
	public CitaDTO modificar(int id, CitaDTO p_cambiar) {
		Optional<Cita> p_encontrado = r_citas.findById(id);
		if(p_encontrado.isPresent()) {
			Cita p_procesado = p_encontrado.get();
			p_procesado.setFecha(p_cambiar.getFecha());
			p_procesado.setAcompnt(r_acompnt.findById(p_cambiar.getAcompnt_id()).get());
			p_procesado.setModalidadCita(ModalidadCita.valueOf(p_cambiar.getModalidadCita()));
			p_procesado.setEstadoCita(EstadoCita.valueOf(p_cambiar.getEstadoCita()));
			return mp_citas.crearDto(r_citas.saveAndFlush(p_procesado));
		} else {
			return null;
		}
	}
	
	public void eliminar(int id) {
		Optional<Cita> p_eliminado = r_citas.findById(id);
		if(p_eliminado.isPresent()) {
			r_citas.deleteById(id);
		}
	}
}
