package org.pe.neurodispuesta.controladores;

import java.text.ParseException;
import java.util.List;

import org.pe.neurodispuesta.servicios.CitaService;
import org.pe.neurodispuesta.transferencias.CitaDTO;
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
@RequestMapping("/api/citas")
public class CitaController {
	
	@Autowired
	private CitaService s_citas;
	
	@GetMapping
	public ResponseEntity<List<CitaDTO>> listar(){
		List<CitaDTO> l_completa = s_citas.listarTodos();
		return new ResponseEntity<>(l_completa, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CitaDTO> buscar(@PathVariable int id){
		return s_citas.buscar(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<CitaDTO> agregar(@RequestBody CitaDTO nuevo) throws ParseException{
		CitaDTO procesado = s_citas.agregar(nuevo);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<CitaDTO> modificar(@PathVariable int id, @RequestBody CitaDTO cambiar) throws ParseException{
		CitaDTO procesado = s_citas.modificar(id, cambiar);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable int id){
		s_citas.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
