package org.pe.neurodispuesta.controladores;

import java.util.Optional;

import org.pe.neurodispuesta.servicios.EspecialistaService;
import org.pe.neurodispuesta.transferencias.EspcDto;
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
@RequestMapping("/api/especialistas")
public class EspecialistasController {
	
	@Autowired
	private EspecialistaService srv_especialistas;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<Object> listar(@RequestParam Optional<Integer> id) {
		try {
			if(id.isPresent()) {
				return new ResponseEntity<Object>(srv_especialistas.buscar(id.get()), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(srv_especialistas.listar(), HttpStatus.OK);
			} 
		} catch(Exception e){
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/activos")//Se utilizará para los menús de la aplicación Web
	public ResponseEntity<Object> listarActivos(){
		return new ResponseEntity<Object>(srv_especialistas.listarActivos(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> agregar(@RequestBody @Valid EspcDto nuevo_e){
		try {
			return new ResponseEntity<Object>(srv_especialistas.agregar(nuevo_e), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<Object>((HttpStatusCode) e);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestParam int id, @RequestBody @Valid EspcDto modificar_c){
		try {
			return new ResponseEntity<Object>(srv_especialistas.modificar(id, modificar_c), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<Object>((HttpStatusCode) e);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Object> eliminar(@RequestParam int id){
		return new ResponseEntity<Object>(srv_especialistas.eliminar(id), HttpStatus.OK);
	}
}
