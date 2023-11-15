package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcompntDTO {
	private int acompntId;
	private Date fechaRegistro;
	private int participanteId;
	private int especialistaId;
	private boolean activo;
}
