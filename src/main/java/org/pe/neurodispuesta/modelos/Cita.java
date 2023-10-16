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
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="citas")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int citaId;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="participante_id")
	private Participante participante;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="especialista_id")
	private Especialista especialista;
	private Date FechaCita;
	private String nota;
	private boolean realizada;
}
