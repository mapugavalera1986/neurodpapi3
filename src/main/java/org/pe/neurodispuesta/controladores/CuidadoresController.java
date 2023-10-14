package org.pe.neurodispuesta.controladores;

import java.util.List;

import org.pe.neurodispuesta.servicios.CuidadorService;
import org.pe.neurodispuesta.transferencias.CompletoCddrDto;
import org.pe.neurodispuesta.transferencias.SimpleCddrDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cuidadores")
public class CuidadoresController {
	
	@Autowired
	private CuidadorService srv_cuidadores;
	
	@GetMapping
	public List<SimpleCddrDto> listar(){
		return srv_cuidadores.listar();
	}
	
	@GetMapping("/participantes")
	public List<CompletoCddrDto> listarTodo(){
		if(srv_cuidadores.listarCompleto().equals(null)) {
			System.out.println("¡Qué!");
		}
		return srv_cuidadores.listarCompleto();
	}
	
	@GetMapping("/{id}")
	public SimpleCddrDto ver(@PathVariable int id) {
		return srv_cuidadores.buscar(id);
	}
}
