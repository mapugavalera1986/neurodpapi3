package org.pe.neurodispuesta.repositorios;

import org.pe.neurodispuesta.modelos.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer>{

}
