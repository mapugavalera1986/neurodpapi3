package org.pe.neurodispuesta.transferencia;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CuidadorDto {
	private int cuidadorId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String correoE;
	private String telf;
}