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
public class Patology {

	
	@Id
	@Column(name = "idpato")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpato;

	@Column(name = "pato")
	@NotNull
	private String pato;
	
	@Column(name = "carename")
	@NotNull
	private String carename;

	@Column(name = "patcf")
	@NotNull
	private String patcf;

	@NotNull
	@Column(name = "quantity")
	private String quantity;

	@NotNull
	@Column(name = "patominpress")
	private int patominpress;
	
	@NotNull
	@Column(name = "patomaxpress")
	private int patomaxpress;
	
	@NotNull
	@Column(name = "patomincir")
	private int patomincir;
	
	@NotNull
	@Column(name = "patomaxcir")
	private int patomaxcir;
	
	@NotNull
	@Column(name = "patominbreath")
	private int patominbreath;
	
	@NotNull
	@Column(name = "patomaxbreath")
	private int patomaxbreath;
	
	@NotNull
	@Column(name = "patomintemp")
	private float patomintemp;
	
	@NotNull
	@Column(name = "patomaxtemp")
	private float patomaxtemp;
}
