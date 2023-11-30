package org.pe.neurodispuesta.modelos;


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
@Table(name="cuidadores")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cuidador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cuidadorId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String correoE;
	private String telf;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuidador")
	private List<Participante> participantes;
}