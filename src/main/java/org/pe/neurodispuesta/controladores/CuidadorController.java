package org.pe.neurodispuesta.controladores;

import java.util.List;

import org.pe.neurodispuesta.servicios.ICuidadorService;
import org.pe.neurodispuesta.transferencia.CuidadorDto;
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
@RequestMapping("/api/apoderados")
public class CuidadorController {

    @Autowired
    private ICuidadorService srvc_cuidadores;

    @GetMapping
    public ResponseEntity<List<CuidadorDto>> listarTodos(){
        List<CuidadorDto> cuidadores = srvc_cuidadores.listarTodos();
        return new ResponseEntity<>(cuidadores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuidadorDto> buscar(@PathVariable int id){
        return srvc_cuidadores.buscar(id)
                .map(cuidador -> new ResponseEntity<>(cuidador,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CuidadorDto> agregar(@RequestBody CuidadorDto CuidadorDto){
        CuidadorDto createdCuidador = srvc_cuidadores.agregar(CuidadorDto);
        return new ResponseEntity<>(createdCuidador,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuidadorDto> modificar(@PathVariable int id,@RequestBody CuidadorDto CuidadorDto){
        CuidadorDto updateCuidador = srvc_cuidadores.modificar(id,CuidadorDto);
        if(updateCuidador != null){
            return new ResponseEntity<>(updateCuidador,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        srvc_cuidadores.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}