package org.pe.neurodispuesta.controladores;

import java.text.ParseException;
import java.util.List;

import org.pe.neurodispuesta.servicios.EspecialistaService;
import org.pe.neurodispuesta.transferencias.EspecialistaDTO;
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
@RequestMapping("/api/especialistas")
public class EspecialistaController {
	
	@Autowired
	private EspecialistaService s_especialistas;
	
	@GetMapping
	public ResponseEntity<List<EspecialistaDTO>> listar(){
		List<EspecialistaDTO> l_completa = s_especialistas.listarTodos();
		return new ResponseEntity<>(l_completa, HttpStatus.OK);
	}
	
	@GetMapping("/activos")
	public ResponseEntity<List<EspecialistaDTO>> listarActivos(){
		List<EspecialistaDTO> l_completa = s_especialistas.listarActivos();
		return new ResponseEntity<>(l_completa, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EspecialistaDTO> buscar(@PathVariable int id){
		return s_especialistas.buscar(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/activos/{id}")
	public ResponseEntity<EspecialistaDTO> buscarActivos(@PathVariable int id){
		return s_especialistas.buscarActivo(id, true).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<EspecialistaDTO> agregar(@RequestBody EspecialistaDTO nuevo) throws ParseException{
		EspecialistaDTO procesado = s_especialistas.agregar(nuevo);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
}
