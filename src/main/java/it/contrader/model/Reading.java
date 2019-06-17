package it.contrader.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reading")
//@NamedQuery(name="Reading.findAll", query="SELECT r FROM Reading r")
public class Reading {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "patcf")
	@NotNull
	private String patcf;

	@Column(name = "regdev")
	@NotNull
	private String regdev;

	@NotNull
	@Column(name = "minpress")
	private int minpress;
	
	@NotNull
	@Column(name = "maxpress")
	private int maxpress;
	
	@NotNull
	@Column(name = "cir")
	private int cir;
	
	@NotNull
	@Column(name = "breath")
	private int breath;
	
	@NotNull
	@Column(name = "temp")
	private float temp;
	
	@Column(name = "giornora")
	@NotNull
	private String giornora;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Date period;
	
	
}
