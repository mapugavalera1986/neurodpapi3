package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.modelos.Participante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsgnDto {
	private Participante participante;
	private Especialista especialista;
	private Date fechaRegistro;
}
