package org.pe.neurodispuesta.transferencias;

import java.util.List;

import io.micrometer.common.lang.NonNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CddrDto {
	@NonNull
	private String nmbrs;
	@NonNull
	private String apllds;
	@NonNull
	private String dni;
	@NonNull
	private String correoE;
	@NonNull
	private String telf;
	private List<SimplePrtcDto> participantes;
}
