package org.pe.neurodispuesta.transferencia;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CitaDto {
	private int citaId;
	private String fecha;
	private int participanteId;
	private int especialistaId;
	private String modalidadCita;
	private String estadoCita;
}
