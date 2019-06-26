package it.contrader.service.impl;

import it.contrader.service.EmergencyService;
import it.contrader.domain.Emergency;
import it.contrader.repository.EmergencyRepository;
import it.contrader.service.dto.EmergencyDTO;
import it.contrader.service.mapper.EmergencyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Emergency.
 */
@Service
@Transactional
public class EmergencyServiceImpl implements EmergencyService {

    private final Logger log = LoggerFactory.getLogger(EmergencyServiceImpl.class);

    private final EmergencyRepository emergencyRepository;

    private final EmergencyMapper emergencyMapper;

    public EmergencyServiceImpl(EmergencyRepository emergencyRepository, EmergencyMapper emergencyMapper) {
        this.emergencyRepository = emergencyRepository;
        this.emergencyMapper = emergencyMapper;
    }

    /**
     * Save a emergency.
     *
     * @param emergencyDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public EmergencyDTO save(EmergencyDTO emergencyDTO) {
        log.debug("Request to save Emergency : {}", emergencyDTO);
        Emergency emergency = emergencyMapper.toEntity(emergencyDTO);
        emergency = emergencyRepository.save(emergency);
        return emergencyMapper.toDto(emergency);
    }

    /**
     * Get all the emergencies.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<EmergencyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Emergencies");
        return emergencyRepository.findAll(pageable)
            .map(emergencyMapper::toDto);
    }


    /**
     * Get one emergency by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<EmergencyDTO> findOne(Long id) {
        log.debug("Request to get Emergency : {}", id);
        return emergencyRepository.findById(id)
            .map(emergencyMapper::toDto);
    }

    /**
     * Delete the emergency by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Emergency : {}", id);
        emergencyRepository.deleteById(id);
    }
}
