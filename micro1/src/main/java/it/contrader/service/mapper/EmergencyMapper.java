package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.EmergencyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Emergency and its DTO EmergencyDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmergencyMapper extends EntityMapper<EmergencyDTO, Emergency> {



    default Emergency fromId(Long id) {
        if (id == null) {
            return null;
        }
        Emergency emergency = new Emergency();
        emergency.setId(id);
        return emergency;
    }
}
