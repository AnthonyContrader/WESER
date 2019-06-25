package it.contrader.service;

import it.contrader.service.dto.EmergencyDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Emergency.
 */
public interface EmergencyService {

    /**
     * Save a emergency.
     *
     * @param emergencyDTO the entity to save
     * @return the persisted entity
     */
    EmergencyDTO save(EmergencyDTO emergencyDTO);

    /**
     * Get all the emergencies.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<EmergencyDTO> findAll(Pageable pageable);


    /**
     * Get the "id" emergency.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<EmergencyDTO> findOne(Long id);

    /**
     * Delete the "id" emergency.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
