package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;

public class ConverterDevice {

	public static DeviceDTO toDTO(Device device) {
		DeviceDTO deviceDTO = null;
		if (device != null) {
			deviceDTO = new DeviceDTO();
			deviceDTO.setId(device.getId());
			deviceDTO.setRegnum(device.getRegnum());
			deviceDTO.setDevtype(device.getDevtype());
			deviceDTO.setDescr(device.getDescr());
			deviceDTO.setMincir(device.getMincir());
			deviceDTO.setMaxcir(device.getMaxcir());
			deviceDTO.setMinpress(device.getMinpress());
			deviceDTO.setMaxpress(device.getMaxpress());
			deviceDTO.setMinbreath(device.getMinbreath());
			deviceDTO.setMaxbreath(device.getMaxbreath());
			deviceDTO.setMintemp(device.getMintemp());
			deviceDTO.setMaxtemp(device.getMaxtemp());
			
		}
		return deviceDTO;
	}

	@SuppressWarnings("null")
	public static Device toEntity(DeviceDTO deviceDTO) {
		Device device = null;
		if (deviceDTO != null) {
			device = new Device();
			device.setId(deviceDTO.getId());
			device.setRegnum(deviceDTO.getRegnum());
			device.setDevtype(deviceDTO.getDevtype());
			device.setDescr(deviceDTO.getDescr());
			device.setMincir(deviceDTO.getMincir());
			device.setMaxcir(deviceDTO.getMaxcir());
			device.setMinpress(deviceDTO.getMinpress());
			device.setMaxpress(deviceDTO.getMaxpress());
			device.setMinbreath(deviceDTO.getMinbreath());
			device.setMaxbreath(deviceDTO.getMaxbreath());
			device.setMintemp(deviceDTO.getMintemp());
			device.setMaxtemp(deviceDTO.getMaxtemp());
		}
		return device;
	}

	public static List<DeviceDTO> toListDTO(List<Device> list) {
		List<DeviceDTO> listDeviceDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Device device : list) {
				listDeviceDTO.add(ConverterDevice.toDTO(device));
			}
		}
		return listDeviceDTO;
	}

	public static List<Device> toListEntity(List<DeviceDTO> listDeviceDTO) {
		List<Device> list = new ArrayList<>();
		if (!listDeviceDTO.isEmpty()) {
			for (DeviceDTO deviceDTO : listDeviceDTO) {
				list.add(ConverterDevice.toEntity(deviceDTO));
			}
		}
		return list;
	}
}
