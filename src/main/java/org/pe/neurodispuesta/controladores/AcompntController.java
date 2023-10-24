package org.pe.neurodispuesta.controladores;

import java.text.ParseException;
import java.util.List;

import org.pe.neurodispuesta.servicios.AcompntService;
import org.pe.neurodispuesta.transferencias.AcompntDTO;
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
@RequestMapping("/api/asignaciones")
public class AcompntController {
	
	@Autowired
	private AcompntService s_acompnts;
	
	@GetMapping
	public ResponseEntity<List<AcompntDTO>> listar(){
		List<AcompntDTO> l_completa = s_acompnts.listarTodos();
		return new ResponseEntity<>(l_completa, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AcompntDTO> buscar(@PathVariable int id){
		return s_acompnts.buscar(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<AcompntDTO> agregar(@RequestBody AcompntDTO nuevo) throws ParseException{
		AcompntDTO procesado = s_acompnts.agregar(nuevo);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<AcompntDTO> modificar(@PathVariable int id, @RequestBody AcompntDTO cambiar) throws ParseException{
		AcompntDTO procesado = s_acompnts.modificar(id, cambiar);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable int id){
		s_acompnts.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
