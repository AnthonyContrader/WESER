package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DeviceDocDTO;
import it.contrader.model.DeviceDoc;

public class ConverterDeviceDoc {

	public static DeviceDocDTO toDTO(DeviceDoc deviceDoc) {
		DeviceDocDTO deviceDocDTO = null;
		if (deviceDoc != null) {
			deviceDocDTO = new DeviceDocDTO();
			deviceDocDTO.setDevId(deviceDoc.getDevId());
			deviceDocDTO.setRegnumber(deviceDoc.getRegnumber());
			deviceDocDTO.setDevtype(deviceDoc.getDevtype());
			deviceDocDTO.setDescription(deviceDoc.getDescription());
			deviceDocDTO.setMinpress(deviceDoc.getMinpress());
			deviceDocDTO.setMaxpress(deviceDoc.getMaxpress());
			deviceDocDTO.setMincir(deviceDoc.getMincir());
			deviceDocDTO.setMaxcir(deviceDoc.getMaxcir());
			deviceDocDTO.setMinbreath(deviceDoc.getMinbreath());
			deviceDocDTO.setMaxbreath(deviceDoc.getMaxbreath());
			deviceDocDTO.setMintemp(deviceDoc.getMintemp());
			deviceDocDTO.setMaxtemp(deviceDoc.getMaxtemp());
		}
		return deviceDocDTO;
	}

	public static DeviceDoc toEntity(DeviceDocDTO deviceDocDTO) {
		DeviceDoc deviceDoc = null;
		if (deviceDocDTO != null) {
			deviceDoc = new DeviceDoc();
			deviceDoc.setDevId(deviceDocDTO.getDevId());
			deviceDoc.setRegnumber(deviceDocDTO.getRegnumber());
			deviceDoc.setDevtype(deviceDocDTO.getDevtype());
			deviceDoc.setDescription(deviceDocDTO.getDescription());
			deviceDoc.setMinpress(deviceDocDTO.getMinpress());
			deviceDoc.setMaxpress(deviceDocDTO.getMaxpress());
			deviceDoc.setMincir(deviceDocDTO.getMincir());
			deviceDoc.setMaxcir(deviceDocDTO.getMaxcir());
			deviceDoc.setMinbreath(deviceDocDTO.getMinbreath());
			deviceDoc.setMaxbreath(deviceDocDTO.getMaxbreath());
			deviceDoc.setMintemp(deviceDocDTO.getMintemp());
			deviceDoc.setMaxtemp(deviceDocDTO.getMaxtemp());
		}
		return deviceDoc;
	}

	public static List<DeviceDocDTO> toListDTO(List<DeviceDoc> listDoc) {
		List<DeviceDocDTO> listDeviceDocDTO = new ArrayList<>();
		if (!listDoc.isEmpty()) {
			for (DeviceDoc deviceDoc : listDoc) {
				listDeviceDocDTO.add(ConverterDeviceDoc.toDTO(deviceDoc));
			}
		}
		return listDeviceDocDTO;
	}

	public static List<DeviceDoc> toListEntity(List<DeviceDocDTO> listDeviceDocDTO) {
		List<DeviceDoc> listDoc = new ArrayList<>();
		if (!listDeviceDocDTO.isEmpty()) {
			for (DeviceDocDTO deviceDocDTO : listDeviceDocDTO) {
				listDoc.add(ConverterDeviceDoc.toEntity(deviceDocDTO));
			}
		}
		return listDoc;
	}
}
