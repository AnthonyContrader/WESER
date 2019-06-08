package it.contrader.converter;

import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class DeviceConverter {

	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Device toEntity(DeviceDTO deviceDTO) {

		Device device = null;
		if (deviceDTO != null) {
			device = new Device(deviceDTO.getRegnumber(),deviceDTO.getDevtype(),deviceDTO.getDescription(),deviceDTO.getMaxpress(),deviceDTO.getMinpress(),deviceDTO.getMaxcir(),deviceDTO.getMincir(),deviceDTO.getMaxbreath(),deviceDTO.getMinbreath(),deviceDTO.getMaxtemp(),deviceDTO.getMintemp());

			if (deviceDTO.getDevId() != 0)
				device.setDevId(deviceDTO.getDevId());
		}
		
		
		return device;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */

	public static DeviceDTO toDTO(Device device) {

		DeviceDTO deviceDTO = null;
		if (device != null) {
			deviceDTO = new DeviceDTO(device.getRegnumber(),device.getDevtype(),device.getDescription(),device.getMaxpress(),device.getMinpress(),device.getMaxcir(),device.getMincir(),device.getMaxbreath(),device.getMinbreath(),device.getMaxtemp(),device.getMintemp());
			deviceDTO.setDevId(device.getDevId());
			// deviceDTO.setId(device.getDeviceId());
		}

		return deviceDTO;
	}

}