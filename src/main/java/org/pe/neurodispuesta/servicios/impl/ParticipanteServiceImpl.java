package org.pe.neurodispuesta.servicios.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeador.ParticipanteMapper;
import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.modelos.Participante;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.servicios.IParticipanteService;
import org.pe.neurodispuesta.transferencia.ParticipanteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParticipanteServiceImpl implements IParticipanteService{
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	@Autowired
	private ParticipanteMapper mp_participantes;

	@Override
	public List<ParticipanteDto> listarTodos() {
		List<Participante> listar = r_participantes.findAll();
		return listar.stream().map(mp_participantes::volverDto).collect(Collectors.toList());
	}

	@Override
	public Optional<ParticipanteDto> buscar(int id) {
		Optional<Participante> encontrado = r_participantes.findById(id);
		return encontrado.map(mp_participantes::volverDto);
	}

	@Override
	public ParticipanteDto agregar(ParticipanteDto c_nuevo) {
		Participante agregar = mp_participantes.volverEntidad(c_nuevo);
		agregar = r_participantes.save(agregar);
		return mp_participantes.volverDto(agregar);
	}

	@Override
	public ParticipanteDto modificar(int id, ParticipanteDto c_cambiar) {
		Optional<Participante> encontrar = r_participantes.findById(id);
		if(encontrar.isPresent()) {
			Participante procesar = mp_participantes.volverEntidad(c_cambiar);
			procesar.setParticipanteId(id);
			procesar = r_participantes.save(procesar);
			return mp_participantes.volverDto(procesar);
		} else {
			return new ParticipanteDto();
		}
	}

	@Override
	public void eliminar(int id) {//Falta añadir las citas
		Optional<Participante> encontrar = r_participantes.findById(id);
		if(encontrar.isPresent()) {
			r_participantes.deleteById(id);
		}
	}

	@Override
	public List<ParticipanteDto> buscarCuidador(int cuidadorId) {
		Optional<Cuidador> encontrar = r_cuidadores.findById(cuidadorId);
		if(encontrar.isPresent()) {
			Cuidador encontrado = encontrar.get();
			List<Participante> buscar_cuidador = r_participantes.findByCuidador(encontrado).get();
			return buscar_cuidador.stream().map(mp_participantes::volverDto).collect(Collectors.toList());
		}else {
			return new LinkedList<ParticipanteDto>();
		}
	}
}