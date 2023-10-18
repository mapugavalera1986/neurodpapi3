package org.pe.neurodispuesta.modelos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	@ManyToOne
	@JoinColumn(name="cuidador_id")
	private Cuidador cuidador;
}