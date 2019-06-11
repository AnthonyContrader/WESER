package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cure {

	
	@Id
	@Column(name = "idcure")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcure;

	@Column(name = "patname")
	@NotNull
	private String patname;

	@Column(name = "patcf")
	@NotNull
	private String patcf;
	
	@NotNull
	@Column(name = "patage")
	private int patage;
	

	@NotNull
	@Column(name = "pato")
	private String pato;

	@NotNull
	@Column(name = "carename")
	private String carename;
	
	@NotNull
	@Column(name = "quantity")
	private String quantity;
	
	@NotNull
	@Column(name = "notes")
	private String notes;
	
}
