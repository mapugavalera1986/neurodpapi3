package org.pe.neurodispuesta.modelos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="especialistas")
public class Especialista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int especialistaId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String ruc;
	private String correoE;
	private String telf;
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;
	private boolean activo;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "especialista")
	private List<Asignar> asignaparticipantes;
}