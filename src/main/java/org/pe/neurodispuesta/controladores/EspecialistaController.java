package org.pe.neurodispuesta.controladores;

import java.util.List;

import org.pe.neurodispuesta.servicios.IEspecialistaService;
import org.pe.neurodispuesta.modelos.Especialista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	private IEspecialistaService s_especialistas;
	
	@GetMapping
	public ResponseEntity<List<Especialista>> listar(){
		List<Especialista> l_completa = s_especialistas.listarTodos();
		return new ResponseEntity<>(l_completa, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialista> buscar(@PathVariable int id){
		return new ResponseEntity<Especialista>(s_especialistas.buscar(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Especialista> agregar(@RequestBody Especialista nuevo){
		Especialista procesado = s_especialistas.agregar(nuevo);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Especialista> modificar(@PathVariable int id, @RequestBody Especialista cambiar){
		Especialista procesado = s_especialistas.modificar(id, cambiar);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable int id){
		s_especialistas.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
