package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
public class CitaDto {
	private int citaId;
	private PrtcDto participante;
	private EspcDto especialista;
	private Date FechaCita;
	private String nota;
	private boolean realizada;
}
