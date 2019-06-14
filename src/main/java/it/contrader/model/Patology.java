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
@Table(name="patology")
@NamedQuery(name="Patology.findAll", query="SELECT u FROM Patology u")
public class Patology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpato")
	private int idpato;

	@Column(name="pato")
	private String pato;
	
	@Column(name="carename")
	private String carename;

	@Column(name="patcf")
	private String patcf;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="patominpress")
	private int patominpress;
	
	@Column(name="patomaxpress")
	private int patomaxpress;

	@Column(name="patomincir")
	private int patomincir;
	
	@Column(name="patomaxcir")
	private int patomaxcir;
	
	@Column(name="patominbreath")
	private int patominbreath;
	
	@Column(name="patomaxbreath")
	private int patomaxbreath;
	
	@Column(name="patomintemp")
	private float patomintemp;
	
	@Column(name="patomaxtemp")
	private float patomaxtemp;
	
}
	//bi-directional many-to-one association to Client
	//@OneToMany(mappedBy="patology")
	//private List<Cure> cures;

	//bi-directional many-to-one association to Item
	//@OneToMany(mappedBy="patology")
	//private List<Device> devices;

	//bi-directional many-to-one association to Order
	//@OneToMany(mappedBy="patology")
	//private List<Emergency> emergencys;

	//bi-directional many-to-one association to Project
	//@OneToMany(mappedBy="patology")
	//private List<Patology> patologys;

	//bi-directional many-to-one association to Resource
	//@OneToMany(mappedBy="patology")
	//private List<Payment> payments;

	//bi-directional many-to-one association to Task
	//@OneToMany(mappedBy="patology")
	//private List<Reading> readings;


