package it.contrader.service;

import it.contrader.service.dto.PatologyDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Patology.
 */
public interface PatologyService {

    /**
     * Save a patology.
     *
     * @param patologyDTO the entity to save
     * @return the persisted entity
     */
    PatologyDTO save(PatologyDTO patologyDTO);

    /**
     * Get all the patologies.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<PatologyDTO> findAll(Pageable pageable);


    /**
     * Get the "id" patology.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PatologyDTO> findOne(Long id);

    /**
     * Delete the "id" patology.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
