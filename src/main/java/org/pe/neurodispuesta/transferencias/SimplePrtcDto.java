package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimplePrtcDto {
	private int participanteId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String correoE;
	private String telf;
	private Date fechaRegistro;
}
