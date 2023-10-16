package org.pe.neurodispuesta.transferencias;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PrtcDto {
	private int participanteId;
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
	@NotNull(message = "necesitas una fecha")
	private Date fechaRegistro;
	@NotNull
	private CddrDto cuidador;
}
