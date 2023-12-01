package org.pe.neurodispuesta.servicios.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pe.neurodispuesta.mapeador.CuidadorMapper;
import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.repositorios.ICuidadorRepository;
import org.pe.neurodispuesta.repositorios.IParticipanteRepository;
import org.pe.neurodispuesta.servicios.ICuidadorService;
import org.pe.neurodispuesta.transferencia.CuidadorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CuidadorServiceImpl implements ICuidadorService{
	
	@Autowired
	private ICuidadorRepository r_cuidadores;
	
	@Autowired
	private IParticipanteRepository r_participantes;
	
	@Autowired
	private CuidadorMapper mp_cuidadores;

	@Override
	public List<CuidadorDto> listarTodos() {
		List<Cuidador> listar = r_cuidadores.findAll();
		return listar.stream().map(mp_cuidadores::volverDto).collect(Collectors.toList());
	}

	@Override
	public Optional<CuidadorDto> buscar(int id) {
		Optional<Cuidador> encontrado = r_cuidadores.findById(id);
		return encontrado.map(mp_cuidadores::volverDto);
	}

	@Override
	public CuidadorDto agregar(CuidadorDto c_nuevo) {
		Cuidador agregar = mp_cuidadores.volverEntidad(c_nuevo);
		agregar = r_cuidadores.save(agregar);
		return mp_cuidadores.volverDto(agregar);
	}

	@Override
	public CuidadorDto modificar(int id, CuidadorDto c_cambiar) {
		Optional<Cuidador> encontrar = r_cuidadores.findById(id);
		if(encontrar.isPresent()) {
			Cuidador procesar = mp_cuidadores.volverEntidad(c_cambiar);
			procesar.setCuidadorId(id);
			procesar = r_cuidadores.save(procesar);
			return mp_cuidadores.volverDto(procesar);
		} else {
			return new CuidadorDto();
		}
	}

	@Override
	public void eliminar(int id) {//Falta agregar borrado de participantesw
		Optional<Cuidador> encontrar = r_cuidadores.findById(id);
		if(encontrar.isPresent()) {
			Cuidador encontrado = encontrar.get();
			r_participantes.deleteByCuidador(encontrado);
			r_cuidadores.deleteById(id);
		}
	}
}