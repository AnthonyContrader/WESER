package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.ReadingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Reading and its DTO ReadingDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReadingMapper extends EntityMapper<ReadingDTO, Reading> {



    default Reading fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reading reading = new Reading();
        reading.setId(id);
        return reading;
    }
}
