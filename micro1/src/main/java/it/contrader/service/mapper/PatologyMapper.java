package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.PatologyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Patology and its DTO PatologyDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PatologyMapper extends EntityMapper<PatologyDTO, Patology> {



    default Patology fromId(Long id) {
        if (id == null) {
            return null;
        }
        Patology patology = new Patology();
        patology.setId(id);
        return patology;
    }
}
