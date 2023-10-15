package org.pe.neurodispuesta.controladores;

import java.util.Optional;

import org.pe.neurodispuesta.servicios.CuidadorService;
import org.pe.neurodispuesta.transferencias.CddrDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody CddrDto nuevo_c){
		return new ResponseEntity<Object>(srv_cuidadores.agregar(nuevo_c), HttpStatus.CREATED);
	}

	@DeleteMapping
	public ResponseEntity<Object> eliminar(@RequestParam int id){
		try {
			srv_cuidadores.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}catch(Exception e){
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
