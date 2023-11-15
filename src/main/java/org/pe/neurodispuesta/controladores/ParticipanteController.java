package org.pe.neurodispuesta.controladores;

import java.text.ParseException;
import java.util.List;

import org.pe.neurodispuesta.servicios.IParticipanteService;
import org.pe.neurodispuesta.transferencias.ParticipanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/inscritos")
public class ParticipanteController {
	
	@Autowired
	private IParticipanteService s_participantes;
	
	@GetMapping
	public ResponseEntity<List<ParticipanteDTO>> listar(){
		List<ParticipanteDTO> l_completa = s_participantes.listarTodos();
		return new ResponseEntity<>(l_completa, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParticipanteDTO> buscar(@PathVariable int id){
		return new ResponseEntity<ParticipanteDTO>(s_participantes.buscar(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ParticipanteDTO> agregar(@RequestBody ParticipanteDTO nuevo) throws ParseException{
		ParticipanteDTO procesado = s_participantes.agregar(nuevo);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ParticipanteDTO> modificar(@PathVariable int id, @RequestBody ParticipanteDTO cambiar) throws ParseException{
		ParticipanteDTO procesado = s_participantes.modificar(id, cambiar);
		return new ResponseEntity<>(procesado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable int id){
		s_participantes.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
