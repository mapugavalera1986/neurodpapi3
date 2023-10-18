package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import lombok.Data;

@Data
public class EspecialistaDTO {
	private int especialistaId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String ruc;
	private String correoE;
	private String telf;
	private Date fechaIngreso;
	private boolean activo;
}
