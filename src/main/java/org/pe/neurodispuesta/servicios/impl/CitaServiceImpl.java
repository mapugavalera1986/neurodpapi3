package org.pe.neurodispuesta.servicios.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeador.CitaMapper;
import org.pe.neurodispuesta.modelos.Cita;
import org.pe.neurodispuesta.repositorios.ICitaRepository;
import org.pe.neurodispuesta.servicios.ICitaService;
import org.pe.neurodispuesta.transferencia.CitaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CitaServiceImpl implements ICitaService{
	
	@Autowired
	private ICitaRepository r_citas;
	
	@Autowired
	private CitaMapper mp_citas;

	@Override
	public List<CitaDto> listarTodos() {
		List<Cita> listar = r_citas.findAll();
		return listar.stream().map(mp_citas::volverDto).collect(Collectors.toList());
	}

	@Override
	public Optional<CitaDto> buscar(int id) {
		Optional<Cita> encontrado = r_citas.findById(id);
		return encontrado.map(mp_citas::volverDto);
	}

	@Override
	public CitaDto agregar(CitaDto c_nuevo) {
		Cita agregar = mp_citas.volverEntidad(c_nuevo);
		agregar = r_citas.save(agregar);
		return mp_citas.volverDto(agregar);
	}

	@Override
	public CitaDto modificar(int id, CitaDto c_cambiar) {
		Optional<Cita> encontrar = r_citas.findById(id);
		if(encontrar.isPresent()) {
			Cita procesar = mp_citas.volverEntidad(c_cambiar);
			procesar.setCitaId(id);
			procesar = r_citas.save(procesar);
			return mp_citas.volverDto(procesar);
		} else {
			return new CitaDto();
		}
	}

	@Override
	public void eliminar(int id) {
		Optional<Cita> encontrar = r_citas.findById(id);
		if(encontrar.isPresent()) {
			r_citas.deleteById(id);
		}
	}
}