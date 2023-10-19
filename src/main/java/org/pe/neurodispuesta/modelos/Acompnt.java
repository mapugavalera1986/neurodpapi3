package org.pe.neurodispuesta.modelos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="asignaciones")
public class Acompnt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int acompntId;
	private Date fechaRegistro;
	@ManyToOne
	@JoinColumn(name="participante_id")
	private Participante participante;
	@ManyToOne
	@JoinColumn(name="especialista_id")
	private Especialista especialista;
	private boolean activo;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acompnt")
	private List<Cita> citas;
}
