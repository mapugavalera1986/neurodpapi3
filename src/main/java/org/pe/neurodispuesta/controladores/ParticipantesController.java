package org.pe.neurodispuesta.controladores;

import java.util.List;

import org.pe.neurodispuesta.servicios.ParticipanteService;
import org.pe.neurodispuesta.transferencias.SimplePrtcDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inscritos")
public class ParticipantesController {
	
	@Autowired
	private ParticipanteService srv_prtcpnts;

	@GetMapping
	public List<SimplePrtcDto> listarParticipantes(){
		return srv_prtcpnts.listar();
	}
	
	@GetMapping("/{id}")
	public SimplePrtcDto ver(@PathVariable int id) {
		return srv_prtcpnts.buscar(id);
	}
}
