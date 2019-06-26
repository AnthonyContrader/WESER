package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.CureDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Cure and its DTO CureDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CureMapper extends EntityMapper<CureDTO, Cure> {



    default Cure fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cure cure = new Cure();
        cure.setId(id);
        return cure;
    }
}
