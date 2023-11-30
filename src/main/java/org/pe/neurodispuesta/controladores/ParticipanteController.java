package org.pe.neurodispuesta.controladores;

import java.text.ParseException;
import java.util.List;

import org.pe.neurodispuesta.servicios.IParticipanteService;
import org.pe.neurodispuesta.transferencia.ParticipanteDto;
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

@RestController
@RequestMapping("/api/inscritos")
public class ParticipanteController {

    @Autowired
    private IParticipanteService srvc_participantes;

    @GetMapping
    public ResponseEntity<List<ParticipanteDto>> listarTodos(){
        List<ParticipanteDto> participantes = srvc_participantes.listarTodos();
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteDto> buscar(@PathVariable int id){
        return srvc_participantes.buscar(id)
                .map(participante -> new ResponseEntity<>(participante,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ParticipanteDto> agregar(@RequestBody ParticipanteDto ParticipanteDto) throws ParseException{
        ParticipanteDto createdParticipante = srvc_participantes.agregar(ParticipanteDto);
        return new ResponseEntity<>(createdParticipante,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteDto> modificar(@PathVariable int id,@RequestBody ParticipanteDto ParticipanteDto){
        ParticipanteDto updateParticipante = srvc_participantes.modificar(id,ParticipanteDto);
        if(updateParticipante != null){
            return new ResponseEntity<>(updateParticipante,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        srvc_participantes.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}