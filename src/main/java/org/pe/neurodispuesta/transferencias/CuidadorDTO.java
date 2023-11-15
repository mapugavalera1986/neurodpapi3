package org.pe.neurodispuesta.transferencias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuidadorDTO {
	private int cuidadorId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String correoE;
	private String telf;
}
