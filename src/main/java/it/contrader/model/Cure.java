package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cure")
@NamedQuery(name="Cure.findAll", query="SELECT c FROM Cure c")
public class Cure implements Serializable {
	private static final long serialVersionUID = 1L;

	
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
	@Column(name = "curename")
	private String curename;
	
	@NotNull
	@Column(name = "quantity")
	private String quantity;
	
	@NotNull
	@Column(name = "notes")
	private String notes;
}
