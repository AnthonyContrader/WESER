package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "regnum")
	@NotNull
	private String regnum;

	@Column(name = "devtype")
	@NotNull
	private String devtype;

	@Column(name = "descr")
	@NotNull
	private String descr;

	@Column(name = "mincir")
	@NotNull
	private int mincir;

	@Column(name = "maxcir")
	@NotNull
	private int maxcir;

	@Column(name = "minpress")
	@NotNull
	private int minpress;

	@Column(name = "maxpress")
	@NotNull
	private int maxpress;
	
	@Column(name = "minbreath")
	@NotNull
	private int minbreath;

	@Column(name = "maxbreath")
	@NotNull
	private int maxbreath;
	
	@Column(name = "mintemp")
	@NotNull
	private float mintemp;

	@Column(name = "maxtemp")
	@NotNull
	private float maxtemp;
	
}