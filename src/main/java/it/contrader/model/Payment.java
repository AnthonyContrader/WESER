package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {

	
	@Id
	@Column(name = "idpay")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpay;

	@Column(name = "cardtype")
	@NotNull
	private String cardtype;

	@Column(name = "cardnumb")
	@NotNull
	private String cardnumb;

	@NotNull
	@Column(name = "cardown")
	private String cardown;

	@NotNull
	@Column(name = "cardexp")
	private String cardexp;
	
	@NotNull
	@Column(name = "cvv")
	private int cvv;
	
}
