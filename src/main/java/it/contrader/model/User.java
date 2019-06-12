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
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iduser")
	private int iduser;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@Column(name="usertype")
	private String usertype;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="ssn")
	private String ssn;

	//bi-directional many-to-one association to Client
	//@OneToMany(mappedBy="user")
	//private List<Cure> cures;

	//bi-directional many-to-one association to Item
	//@OneToMany(mappedBy="user")
	//private List<Device> devices;

	//bi-directional many-to-one association to Order
	//@OneToMany(mappedBy="user")
	//private List<Emergency> emergencys;

	//bi-directional many-to-one association to Project
	//@OneToMany(mappedBy="user")
	//private List<Patology> patologys;

	//bi-directional many-to-one association to Resource
	//@OneToMany(mappedBy="user")
	//private List<Payment> payments;

	//bi-directional many-to-one association to Task
	//@OneToMany(mappedBy="user")
	//private List<Reading> readings;


}