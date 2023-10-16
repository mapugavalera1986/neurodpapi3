package org.pe.neurodispuesta.transferencias;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CddrDto {
	private int cuidadorId;
	@NotBlank(message = "Coloca unos nombres")
	private String nmbrs;
	@NotBlank(message = "Coloca unos apellidos")
	private String apllds;
	@NotBlank(message = "Coloca un DNI válido")
	private String dni;
	@NotBlank(message = "Coloca un correo electrónico")
	private String correoE;
	@NotBlank(message = "Coloca un teléfono")
	private String telf;
	private List<PrtcDto> participantes;
}
