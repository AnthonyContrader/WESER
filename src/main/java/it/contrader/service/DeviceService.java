package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.DeviceRepository;
import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;

/**
 * Estende AbstractService con parametri Device e DeviceDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class DeviceService extends AbstractService<Device,DeviceDTO> {
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public DeviceDTO findById(int id) {
		return converter.toDTO(((DeviceRepository)repository).findById(id));
	}

}
