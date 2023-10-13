package org.pe.neurodispuesta.controladores;

import java.util.List;

import org.pe.neurodispuesta.servicios.EspecialistaService;
import org.pe.neurodispuesta.transferencias.SimpleEspcDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/especialistas")
public class EspecialistasController {
	
	@Autowired
	private EspecialistaService srv_especialistas;

	@GetMapping
	public List<SimpleEspcDto> listarEspecialistas(){
		return srv_especialistas.listar();
	}
	
	@GetMapping("/{id}")
	public SimpleEspcDto ver(@PathVariable int id) {
		return srv_especialistas.buscar(id);
	}
}
