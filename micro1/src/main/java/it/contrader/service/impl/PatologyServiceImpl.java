package it.contrader.service.impl;

import it.contrader.service.PatologyService;
import it.contrader.domain.Patology;
import it.contrader.repository.PatologyRepository;
import it.contrader.service.dto.PatologyDTO;
import it.contrader.service.mapper.PatologyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Patology.
 */
@Service
@Transactional
public class PatologyServiceImpl implements PatologyService {

    private final Logger log = LoggerFactory.getLogger(PatologyServiceImpl.class);

    private final PatologyRepository patologyRepository;

    private final PatologyMapper patologyMapper;

    public PatologyServiceImpl(PatologyRepository patologyRepository, PatologyMapper patologyMapper) {
        this.patologyRepository = patologyRepository;
        this.patologyMapper = patologyMapper;
    }

    /**
     * Save a patology.
     *
     * @param patologyDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PatologyDTO save(PatologyDTO patologyDTO) {
        log.debug("Request to save Patology : {}", patologyDTO);
        Patology patology = patologyMapper.toEntity(patologyDTO);
        patology = patologyRepository.save(patology);
        return patologyMapper.toDto(patology);
    }

    /**
     * Get all the patologies.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PatologyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Patologies");
        return patologyRepository.findAll(pageable)
            .map(patologyMapper::toDto);
    }


    /**
     * Get one patology by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PatologyDTO> findOne(Long id) {
        log.debug("Request to get Patology : {}", id);
        return patologyRepository.findById(id)
            .map(patologyMapper::toDto);
    }

    /**
     * Delete the patology by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Patology : {}", id);
        patologyRepository.deleteById(id);
    }
}
