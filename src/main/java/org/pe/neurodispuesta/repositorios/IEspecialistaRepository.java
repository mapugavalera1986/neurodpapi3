package org.pe.neurodispuesta.repositorios;

import java.util.List;
import java.util.Optional;

import org.pe.neurodispuesta.modelos.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialistaRepository extends JpaRepository<Especialista, Integer> {
	List<Especialista> findAllByActivo(boolean activo);
	Optional<Especialista> findByEspecialistaIdAndActivo(int id, boolean activo);
}