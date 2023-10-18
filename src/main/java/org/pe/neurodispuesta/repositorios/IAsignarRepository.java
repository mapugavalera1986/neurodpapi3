package org.pe.neurodispuesta.repositorios;

import java.util.List;

import org.pe.neurodispuesta.modelos.Asignar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsignarRepository extends JpaRepository<Asignar, Integer> {
}
