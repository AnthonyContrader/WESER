package it.contrader.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reading {

	
	@Id
	@Column(name = "idread")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idread;

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
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Date period;
	
	
}
