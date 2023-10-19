package org.pe.neurodispuesta.repositorios;

import org.pe.neurodispuesta.modelos.Acompnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcompntRepository extends JpaRepository<Acompnt, Integer> {

}