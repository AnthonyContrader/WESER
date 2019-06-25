package it.contrader.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import it.contrader.domain.Emergency;
import it.contrader.domain.*; // for static metamodels
import it.contrader.repository.EmergencyRepository;
import it.contrader.service.dto.EmergencyCriteria;

import it.contrader.service.dto.EmergencyDTO;
import it.contrader.service.mapper.EmergencyMapper;

/**
 * Service for executing complex queries for Emergency entities in the database.
 * The main input is a {@link EmergencyCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link EmergencyDTO} or a {@link Page} of {@link EmergencyDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class EmergencyQueryService extends QueryService<Emergency> {

    private final Logger log = LoggerFactory.getLogger(EmergencyQueryService.class);

    private final EmergencyRepository emergencyRepository;

    private final EmergencyMapper emergencyMapper;

    public EmergencyQueryService(EmergencyRepository emergencyRepository, EmergencyMapper emergencyMapper) {
        this.emergencyRepository = emergencyRepository;
        this.emergencyMapper = emergencyMapper;
    }

    /**
     * Return a {@link List} of {@link EmergencyDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<EmergencyDTO> findByCriteria(EmergencyCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Emergency> specification = createSpecification(criteria);
        return emergencyMapper.toDto(emergencyRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link EmergencyDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<EmergencyDTO> findByCriteria(EmergencyCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Emergency> specification = createSpecification(criteria);
        return emergencyRepository.findAll(specification, page)
            .map(emergencyMapper::toDto);
    }

    /**
     * Function to convert EmergencyCriteria to a {@link Specification}
     */
    private Specification<Emergency> createSpecification(EmergencyCriteria criteria) {
        Specification<Emergency> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), Emergency_.id));
            }
            if (criteria.getNum() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNum(), Emergency_.num));
            }
        }
        return specification;
    }

}
