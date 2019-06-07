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
			device = new Device(deviceDTO.getRegnumber(),deviceDTO.getDevtype(),deviceDTO.getDescription(),deviceDTO.getMinpress(),deviceDTO.getMaxpress(),deviceDTO.getMincir(),deviceDTO.getMaxcir(),deviceDTO.getMinbreath(),deviceDTO.getMaxbreath(),deviceDTO.getMintemp(),deviceDTO.getMaxtemp());

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
			deviceDTO = new DeviceDTO(device.getRegnumber(),device.getDevtype(),device.getDescription(),device.getMinpress(),device.getMaxpress(),device.getMincir(),device.getMaxcir(),device.getMinbreath(),device.getMaxbreath(),device.getMintemp(),device.getMaxtemp());
			deviceDTO.setDevId(device.getDevId());
			// deviceDTO.setId(device.getDeviceId());
		}

		return deviceDTO;
	}

}