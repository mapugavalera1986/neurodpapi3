package org.pe.neurodispuesta.repositorios;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuidadorRepository extends JpaRepository<Cuidador, Integer>{

}
