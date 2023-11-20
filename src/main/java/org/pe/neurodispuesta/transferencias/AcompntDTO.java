package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import lombok.Data;

@Data
public class AcompntDTO {
	private int acompntId;
	private Date fechaRegistro;
	private int participanteId;
	private int especialistaId;
	private boolean activo;
}
