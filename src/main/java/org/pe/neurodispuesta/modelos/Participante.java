package org.pe.neurodispuesta.modelos;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Participantes")
public class Participante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int participanteId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String correoE;
	private String telf;
	private Date fechaRegistro;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="cuidador_id")
	private Cuidador cuidador;
}