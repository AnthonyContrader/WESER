package it.contrader.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO della classe User. Ha gli stessi attributi di User
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PaymentDTO {

	@Column(unique = true)
	
	private long id;
	
	private String ct;
	
	private String cn;
	
	private String co;
	
	private String ce;
	
	int cvv;

}
