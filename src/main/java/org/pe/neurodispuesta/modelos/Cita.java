package org.pe.neurodispuesta.modelos;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int citaId;
	private Asignar asigna_especialista;
	@Enumerated(EnumType.STRING)
	private ModalidadCita modalidadCita;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Enumerated(EnumType.STRING)
	private EstadoCita estadoCita;
}
