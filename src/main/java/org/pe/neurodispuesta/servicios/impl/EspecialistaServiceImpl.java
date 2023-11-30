package org.pe.neurodispuesta.servicios.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeador.EspecialistaMapper;
import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.repositorios.IEspecialistaRepository;
import org.pe.neurodispuesta.servicios.IEspecialistaService;
import org.pe.neurodispuesta.transferencia.EspecialistaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EspecialistaServiceImpl implements IEspecialistaService{
	
	@Autowired
	private IEspecialistaRepository r_especialistas;
	
	@Autowired
	private EspecialistaMapper mp_especialistas;

	@Override
	public List<EspecialistaDto> listarTodos() {
		List<Especialista> listar = r_especialistas.findAll();
		return listar.stream().map(mp_especialistas::volverDto).collect(Collectors.toList());
	}

	@Override
	public Optional<EspecialistaDto> buscar(int id) {
		Optional<Especialista> encontrado = r_especialistas.findById(id);
		return encontrado.map(mp_especialistas::volverDto);
	}

	@Override
	public EspecialistaDto agregar(EspecialistaDto c_nuevo) {
		Especialista agregar = mp_especialistas.volverEntidad(c_nuevo);
		agregar = r_especialistas.save(agregar);
		return mp_especialistas.volverDto(agregar);
	}

	@Override
	public EspecialistaDto modificar(int id, EspecialistaDto c_cambiar) {
		Optional<Especialista> encontrar = r_especialistas.findById(id);
		if(encontrar.isPresent()) {
			Especialista procesar = mp_especialistas.volverEntidad(c_cambiar);
			procesar.setEspecialistaId(id);
			procesar = r_especialistas.save(procesar);
			return mp_especialistas.volverDto(procesar);
		} else {
			return null;
		}
	}

	@Override
	public void eliminar(int id) {//Falta agregar las citas
		Optional<Especialista> encontrar = r_especialistas.findById(id);
		if(encontrar.isPresent()) {
			//Especialista encontrado = encontrar.get();
			//r_participantes.deleteByEspecialista(encontrado);
			r_especialistas.deleteById(id);
		}
	}
}