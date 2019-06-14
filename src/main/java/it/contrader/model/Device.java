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
@Table(name="device")
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "iddev")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddev;

	@Column(name = "regnumber")
	@NotNull
	private String regnumber;

	@Column(name = "devtype")
	@NotNull
	private String devtype;

	@NotNull
	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "minpress")
	private int minpress;
	
	@NotNull
	@Column(name = "maxpress")
	private int maxpress;
	
	@NotNull
	@Column(name = "mincir")
	private int mincir;
	
	@NotNull
	@Column(name = "maxcir")
	private int maxcir;
	
	@NotNull
	@Column(name = "minbreath")
	private int minbreath;
	
	@NotNull
	@Column(name = "maxbreath")
	private int maxbreath;
	
	@NotNull
	@Column(name = "mintemp")
	private float mintemp;
	
	@NotNull
	@Column(name = "maxtemp")
	private float maxtemp;
}
