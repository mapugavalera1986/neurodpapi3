package org.pe.neurodispuesta.repositorios;

import org.pe.neurodispuesta.modelos.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialistaRepository extends JpaRepository<Especialista, Integer>{

}
