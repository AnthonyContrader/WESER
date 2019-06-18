package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CureDTO;


/**
 * 
 * Questa classe estende AbstractController con tipo CureDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<CureDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/cure")
@CrossOrigin(origins = "http://localhost:4200")
public class CureController extends AbstractController<CureDTO>{
	
}