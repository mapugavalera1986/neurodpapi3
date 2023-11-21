package org.pe.neurodispuesta.modelos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="especialistas")
@JsonInclude(JsonInclude.Include.NON_NULL) 
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
	private LocalDate fechaIngreso;
	private boolean activo;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "especialista")
	private List<Acompnt> acompnts;
}