package org.pe.neurodispuesta.repositorios;

import org.pe.neurodispuesta.modelos.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParticipanteRepository extends JpaRepository<Participante, Integer> {

}
