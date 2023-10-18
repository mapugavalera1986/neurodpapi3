package org.pe.neurodispuesta.controladores;

import java.text.ParseException;
import java.util.List;

import org.pe.neurodispuesta.servicios.ParticipanteService;
import org.pe.neurodispuesta.transferencias.ParticipanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inscritos")
public class ParticipanteController {
	
	@Autowired
	private ParticipanteService s_participantes;
	
	@GetMapping
	public ResponseEntity<List<ParticipanteDTO>> listar(){
		List<ParticipanteDTO> l_completa = s_participantes.listarTodos();
		return new ResponseEntity<>(l_completa, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParticipanteDTO> buscar(@PathVariable int id){
		return s_participantes.buscar(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<ParticipanteDTO> agregar(@RequestBody ParticipanteDTO nuevo) throws ParseException{
		ParticipanteDTO procesado = s_participantes.agregar(nuevo);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}

}
