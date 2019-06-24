package it.contrader.model;

import javax.persistence.Entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati
 * come interi a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reading {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cf;

	private String rd;

	private int mp;

	private int mpr;
	
	private int cir;
	
	private int bre;

	private float temp;
	
	private String dataora;

}
