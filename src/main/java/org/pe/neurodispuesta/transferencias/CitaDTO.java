package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import lombok.Data;

@Data
public class CitaDTO {
	private int citaId;
	private int asignarId;
	private String modalidadCita;
	private Date fecha;
	private String estadoCita;
}
