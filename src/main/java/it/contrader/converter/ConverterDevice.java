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
			deviceDTO.setDevId(device.getDevId());
			deviceDTO.setRegnumber(device.getRegnumber());
			deviceDTO.setDevtype(device.getDevtype());
			deviceDTO.setDescription(device.getDescription());
			deviceDTO.setMinpress(device.getMinpress());
			deviceDTO.setMaxpress(device.getMaxpress());
			deviceDTO.setMincir(device.getMincir());
			deviceDTO.setMaxcir(device.getMaxcir());
			deviceDTO.setMinbreath(device.getMinbreath());
			deviceDTO.setMaxbreath(device.getMaxbreath());
			deviceDTO.setMintemp(device.getMintemp());
			deviceDTO.setMaxtemp(device.getMaxtemp());
		}
		return deviceDTO;
	}

	public static Device toEntity(DeviceDTO deviceDTO) {
		Device device = null;
		if (deviceDTO != null) {
			device = new Device();
			device.setDevId(deviceDTO.getDevId());
			device.setRegnumber(deviceDTO.getRegnumber());
			device.setDescription(deviceDTO.getDescription());
			device.setDevtype(deviceDTO.getDevtype());
			device.setMinpress(deviceDTO.getMinpress());
			device.setMaxpress(deviceDTO.getMaxpress());
			device.setMincir(deviceDTO.getMincir());
			device.setMaxcir(deviceDTO.getMaxcir());
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
