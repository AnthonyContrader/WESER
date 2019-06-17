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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cure")
//@NamedQuery(name="Cure.findAll", query="SELECT c FROM Cure c")
public class Cure {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "patname")
	@NotNull
	private String patname;

	@Column(name = "patcf")
	@NotNull
	private String patcf;
	
	@Column(name = "patage")
	@NotNull
	private int patage;

	@Column(name = "pato")
	@NotNull
	private String pato;
	
	@Column(name = "curename")
	@NotNull
	private String curename;
	
	@Column(name = "quantity")
	@NotNull
	private String quantity;
	
	@Column(name = "notes")
	@NotNull
	private String notes;
}
