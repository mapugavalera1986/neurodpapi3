package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import lombok.Data;

@Data
public class CitaDTO {
	private int citaId;
	private Date fecha;
	private int acompnt_id;
	private String modalidadCita;
	private String estadoCita;
}
