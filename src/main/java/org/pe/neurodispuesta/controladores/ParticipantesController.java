package org.pe.neurodispuesta.controladores;

import java.util.Optional;

import org.pe.neurodispuesta.servicios.ParticipanteService;
import org.pe.neurodispuesta.transferencias.PrtcDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/participantes")
public class ParticipantesController {
	
	@Autowired
	private ParticipanteService srv_participantes;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<Object> listar(@RequestParam Optional<Integer> id) {
		try {
			if(id.isPresent()) {
				return new ResponseEntity<Object>(srv_participantes.buscar(id.get()), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(srv_participantes.listar(), HttpStatus.OK);
			} 
		} catch(Exception e){
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> agregar(@RequestBody @Valid PrtcDto nuevo_p){
		try {
			return new ResponseEntity<Object>(srv_participantes.agregar(nuevo_p), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<Object>((HttpStatusCode) e);
		}
	}

	@PutMapping
	public ResponseEntity<Object> modificar(@RequestParam int id, @RequestBody @Valid PrtcDto modificar_p){
		try {
			return new ResponseEntity<Object>(srv_participantes.modificar(id, modificar_p), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<Object>((HttpStatusCode) e);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Object> eliminar(@RequestParam int id){
		try {
			srv_participantes.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
