package org.pe.neurodispuesta.repositorios;

import java.util.List;

import org.pe.neurodispuesta.modelos.Cuidador;
import org.pe.neurodispuesta.modelos.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParticipanteRepository extends JpaRepository<Participante, Integer>{
	List<Participante> findAllByCuidador(Cuidador buscar_c);
}
