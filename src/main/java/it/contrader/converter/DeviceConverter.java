package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DeviceDTO;

import it.contrader.model.Device;

/**
 * Questa classe implementa i metodi di conversione dell'entità Device.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class DeviceConverter extends AbstractConverter<Device,DeviceDTO> {

	@Override
	public Device toEntity(DeviceDTO deviceDTO) {
		Device device = null;
		if (deviceDTO != null) {
			device = new Device(deviceDTO.getId(),deviceDTO.getDevtype(),deviceDTO.getDescr(),deviceDTO.getMp(),deviceDTO.getMpr(),deviceDTO.getMc(),deviceDTO.getMci(),deviceDTO.getMb(),deviceDTO.getMbr(),deviceDTO.getMt(),deviceDTO.getMte());			
		}
		return device;
	}

	@Override
	public DeviceDTO toDTO(Device device) {
		DeviceDTO deviceDTO = null;
		if (device != null) {
			deviceDTO = new DeviceDTO(device.getId(),device.getDevtype(),device.getDescr(),device.getMp(),device.getMpr(),device.getMc(),device.getMci(),device.getMb(),device.getMbr(),device.getMt(),device.getMte());	
			
		}
		return deviceDTO;
	}
}