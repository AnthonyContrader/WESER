package it.contrader.service;

import it.contrader.service.dto.CureDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Cure.
 */
public interface CureService {

    /**
     * Save a cure.
     *
     * @param cureDTO the entity to save
     * @return the persisted entity
     */
    CureDTO save(CureDTO cureDTO);

    /**
     * Get all the cures.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<CureDTO> findAll(Pageable pageable);


    /**
     * Get the "id" cure.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CureDTO> findOne(Long id);

    /**
     * Delete the "id" cure.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
