package org.pe.neurodispuesta.controladores;

import java.util.List;

import org.pe.neurodispuesta.servicios.IEspecialistaService;
import org.pe.neurodispuesta.transferencia.EspecialistaDto;
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
@RequestMapping("/api/especialistas")
public class EspecialistaController {

    @Autowired
    private IEspecialistaService srvc_especialistas;

    @GetMapping
    public ResponseEntity<List<EspecialistaDto>> listarTodos(){
        List<EspecialistaDto> especialistas = srvc_especialistas.listarTodos();
        return new ResponseEntity<>(especialistas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialistaDto> buscar(@PathVariable int id){
        return srvc_especialistas.buscar(id)
                .map(especialista -> new ResponseEntity<>(especialista,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<EspecialistaDto> agregar(@RequestBody EspecialistaDto EspecialistaDto){
        EspecialistaDto createdEspecialista = srvc_especialistas.agregar(EspecialistaDto);
        return new ResponseEntity<>(createdEspecialista,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialistaDto> modificar(@PathVariable int id,@RequestBody EspecialistaDto EspecialistaDto){
        EspecialistaDto updateEspecialista = srvc_especialistas.modificar(id,EspecialistaDto);
        if(updateEspecialista != null){
            return new ResponseEntity<>(updateEspecialista,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        srvc_especialistas.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}