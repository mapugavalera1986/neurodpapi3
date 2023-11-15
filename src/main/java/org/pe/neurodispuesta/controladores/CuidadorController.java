package org.pe.neurodispuesta.controladores;

import java.text.ParseException;
import java.util.List;

import org.pe.neurodispuesta.servicios.ICuidadorService;
import org.pe.neurodispuesta.transferencias.CuidadorDTO;
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
@RequestMapping("/api/apoderados")
public class CuidadorController {
	
	@Autowired
	private ICuidadorService s_cuidadores;
	
	@GetMapping
	public ResponseEntity<List<CuidadorDTO>> listar(){
		List<CuidadorDTO> l_completa = s_cuidadores.listarTodos();
		return new ResponseEntity<>(l_completa, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CuidadorDTO> buscar(@PathVariable int id){
		return new ResponseEntity<CuidadorDTO>(s_cuidadores.buscar(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CuidadorDTO> agregar(@RequestBody CuidadorDTO nuevo) throws ParseException{
		CuidadorDTO procesado = s_cuidadores.agregar(nuevo);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<CuidadorDTO> modificar(@PathVariable int id, @RequestBody CuidadorDTO cambiar) throws ParseException{
		CuidadorDTO procesado = s_cuidadores.modificar(id, cambiar);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable int id){
		s_cuidadores.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
