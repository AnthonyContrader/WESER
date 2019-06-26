package it.contrader.service.impl;

import it.contrader.service.ReadingService;
import it.contrader.domain.Reading;
import it.contrader.repository.ReadingRepository;
import it.contrader.service.dto.ReadingDTO;
import it.contrader.service.mapper.ReadingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Reading.
 */
@Service
@Transactional
public class ReadingServiceImpl implements ReadingService {

    private final Logger log = LoggerFactory.getLogger(ReadingServiceImpl.class);

    private final ReadingRepository readingRepository;

    private final ReadingMapper readingMapper;

    public ReadingServiceImpl(ReadingRepository readingRepository, ReadingMapper readingMapper) {
        this.readingRepository = readingRepository;
        this.readingMapper = readingMapper;
    }

    /**
     * Save a reading.
     *
     * @param readingDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ReadingDTO save(ReadingDTO readingDTO) {
        log.debug("Request to save Reading : {}", readingDTO);
        Reading reading = readingMapper.toEntity(readingDTO);
        reading = readingRepository.save(reading);
        return readingMapper.toDto(reading);
    }

    /**
     * Get all the readings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ReadingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Readings");
        return readingRepository.findAll(pageable)
            .map(readingMapper::toDto);
    }


    /**
     * Get one reading by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReadingDTO> findOne(Long id) {
        log.debug("Request to get Reading : {}", id);
        return readingRepository.findById(id)
            .map(readingMapper::toDto);
    }

    /**
     * Delete the reading by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Reading : {}", id);
        readingRepository.deleteById(id);
    }
}
