package it.contrader.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati come interi
 * a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String cf;
	
	private String age;
	
	private String pato;
	
	private String name;
	
	private String quantity;
	
	private String notes;

	
	
}
