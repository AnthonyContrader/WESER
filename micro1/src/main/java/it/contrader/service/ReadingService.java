package it.contrader.service;

import it.contrader.service.dto.ReadingDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Reading.
 */
public interface ReadingService {

    /**
     * Save a reading.
     *
     * @param readingDTO the entity to save
     * @return the persisted entity
     */
    ReadingDTO save(ReadingDTO readingDTO);

    /**
     * Get all the readings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ReadingDTO> findAll(Pageable pageable);


    /**
     * Get the "id" reading.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ReadingDTO> findOne(Long id);

    /**
     * Delete the "id" reading.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
