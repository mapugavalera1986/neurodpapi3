package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import org.pe.neurodispuesta.modelos.Especialista;
import org.pe.neurodispuesta.modelos.Participante;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AsgnDto {
	private Participante participante;
	private Especialista especialista;
	private Date fechaRegistro;
}
