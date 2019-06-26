package it.contrader.service.impl;

import it.contrader.service.CureService;
import it.contrader.domain.Cure;
import it.contrader.repository.CureRepository;
import it.contrader.service.dto.CureDTO;
import it.contrader.service.mapper.CureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Cure.
 */
@Service
@Transactional
public class CureServiceImpl implements CureService {

    private final Logger log = LoggerFactory.getLogger(CureServiceImpl.class);

    private final CureRepository cureRepository;

    private final CureMapper cureMapper;

    public CureServiceImpl(CureRepository cureRepository, CureMapper cureMapper) {
        this.cureRepository = cureRepository;
        this.cureMapper = cureMapper;
    }

    /**
     * Save a cure.
     *
     * @param cureDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CureDTO save(CureDTO cureDTO) {
        log.debug("Request to save Cure : {}", cureDTO);
        Cure cure = cureMapper.toEntity(cureDTO);
        cure = cureRepository.save(cure);
        return cureMapper.toDto(cure);
    }

    /**
     * Get all the cures.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CureDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cures");
        return cureRepository.findAll(pageable)
            .map(cureMapper::toDto);
    }


    /**
     * Get one cure by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CureDTO> findOne(Long id) {
        log.debug("Request to get Cure : {}", id);
        return cureRepository.findById(id)
            .map(cureMapper::toDto);
    }

    /**
     * Delete the cure by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Cure : {}", id);
        cureRepository.deleteById(id);
    }
}
