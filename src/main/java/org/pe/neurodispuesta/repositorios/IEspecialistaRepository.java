package org.pe.neurodispuesta.repositorios;

import java.util.List;

import org.pe.neurodispuesta.modelos.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialistaRepository extends JpaRepository<Especialista, Integer> {
	List<Especialista> findByActivo(boolean activo);
}