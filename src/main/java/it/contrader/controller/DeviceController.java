package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DeviceDTO;


/**
 * 
 * Questa classe estende AbstractController con tipo DeviceDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<DeviceDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/device")
@CrossOrigin(origins = "http://localhost:4200")
public class DeviceController extends AbstractController<DeviceDTO>{
	

}