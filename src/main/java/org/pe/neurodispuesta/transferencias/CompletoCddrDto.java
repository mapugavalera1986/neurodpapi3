package org.pe.neurodispuesta.transferencias;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompletoCddrDto {
	private int cuidadorId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String correoE;
	private String telf;
	private List<SimplePrtcDto> participantes;
}
