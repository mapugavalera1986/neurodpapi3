package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import lombok.Data;

@Data
public class AsignarEspecialistaDTO {
	private int asignarId;
	private int participanteId;
	private int especialistaId;
	private Date fechaEstablecimiento;
	private boolean activa;
	
}
