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
@Table(name="emergency")
@NamedQuery(name="Emergency.findAll", query="SELECT e FROM Emergency e")
public class Emergency implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idem")
	@NotNull
	private int idem;

	@Column(name="emnum")
	@NotNull
	private String emnum;
	
	
	

	//bi-directional many-to-one association to Client
	//@OneToMany(mappedBy="emergency")
	//private List<Cure> cures;

	//bi-directional many-to-one association to Item
	//@OneToMany(mappedBy="emergency")
	//private List<Device> devices;

	//bi-directional many-to-one association to Order
	//@OneToMany(mappedBy="emergency")
	//private List<Emergency> emergencys;

	//bi-directional many-to-one association to Project
	//@OneToMany(mappedBy="emergency")
	//private List<Patology> patologys;

	//bi-directional many-to-one association to Resource
	//@OneToMany(mappedBy="emergency")
	//private List<Payment> payments;

	//bi-directional many-to-one association to Task
	//@OneToMany(mappedBy="emergency")
	//private List<Reading> readings;

 
}