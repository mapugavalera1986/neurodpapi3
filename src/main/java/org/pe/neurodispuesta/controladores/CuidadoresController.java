package org.pe.neurodispuesta.controladores;

import java.util.Optional;

import org.pe.neurodispuesta.servicios.CuidadorService;
import org.pe.neurodispuesta.transferencias.CddrDto;
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
@RequestMapping("/api/cuidadores")
public class CuidadoresController {
	
	@Autowired
	private CuidadorService srv_cuidadores;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<Object> listar(@RequestParam Optional<Integer> id) {
		try {
			if(id.isPresent()) {
				return new ResponseEntity<Object>(srv_cuidadores.buscar(id.get()), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(srv_cuidadores.listar(), HttpStatus.OK);
			} 
		} catch(Exception e){
			return new ResponseEntity<Object>((HttpStatusCode) e);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> agregar(@RequestBody @Valid CddrDto nuevo_c){
		try {
			return new ResponseEntity<Object>(srv_cuidadores.agregar(nuevo_c), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<Object>((HttpStatusCode) e);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestParam int id, @RequestBody @Valid CddrDto modificar_c){
		try {
			return new ResponseEntity<Object>(srv_cuidadores.modificar(id, modificar_c), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<Object>((HttpStatusCode) e);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Object> eliminar(@RequestParam int id){
		return new ResponseEntity<Object>(srv_cuidadores.eliminar(id), HttpStatus.OK);
	}
}
