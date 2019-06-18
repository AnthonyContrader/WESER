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
@Table(name="payment")
@NamedQuery(name="Payment.findAll", query="SELECT u FROM Payment u")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpay")
	private int idpay;

	@Column(name="cardtype")
	private String cardtype;
	
	@Column(name="cardnumb")
	private String cardnumb;
	
	@Column(name="cardown")
	private String cardown;
	
	@Column(name="cardexp")
	private String cardexp;
	
	@Column(name="cvv")
	private int cvv;
	
	
	//bi-directional many-to-one association to Client
	//@OneToMany(mappedBy="payment")
	//private List<Cure> cures;

	//bi-directional many-to-one association to Item
	//@OneToMany(mappedBy="payment")
	//private List<Device> devices;

	//bi-directional many-to-one association to Order
	//@OneToMany(mappedBy="payment")
	//private List<Emergency> emergencys;

	//bi-directional many-to-one association to Project
	//@OneToMany(mappedBy="payment")
	//private List<Patology> patologys;

	//bi-directional many-to-one association to Resource
	//@OneToMany(mappedBy="payment")
	//private List<Payment> payments;

	//bi-directional many-to-one association to Task
	//@OneToMany(mappedBy="payment")
	//private List<Reading> readings;


}