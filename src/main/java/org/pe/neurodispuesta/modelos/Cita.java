package org.pe.neurodispuesta.modelos;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="citas")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int citaId;
	private Date fecha;
	@ManyToOne
	@JoinColumn(name="acompnt_id")
	private Acompnt acompnt;
	@Enumerated(EnumType.STRING)
	private ModalidadCita modalidadCita;
	@Enumerated(EnumType.STRING)
	private EstadoCita estadoCita;
}
