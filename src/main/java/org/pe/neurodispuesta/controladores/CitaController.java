package org.pe.neurodispuesta.controladores;

import java.util.List;

import org.pe.neurodispuesta.servicios.ICitaService;
import org.pe.neurodispuesta.transferencia.CitaDto;
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
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private ICitaService srvc_citas;

    @GetMapping
    public ResponseEntity<List<CitaDto>> listarTodos(){
        List<CitaDto> citas = srvc_citas.listarTodos();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDto> buscar(@PathVariable int id){
        return srvc_citas.buscar(id)
                .map(cuidador -> new ResponseEntity<>(cuidador,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CitaDto> agregar(@RequestBody CitaDto CitaDto){
        CitaDto createdCita = srvc_citas.agregar(CitaDto);
        return new ResponseEntity<>(createdCita,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDto> modificar(@PathVariable int id,@RequestBody CitaDto CitaDto){
        CitaDto updateCita = srvc_citas.modificar(id,CitaDto);
        if(updateCita != null){
            return new ResponseEntity<>(updateCita,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        srvc_citas.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}