package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {
	private int citaId;
	private Date fecha;
	private int acompnt_id;
	private String modalidadCita;
	private String estadoCita;
}
