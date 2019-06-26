package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.CureService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.web.rest.util.PaginationUtil;
import it.contrader.service.dto.CureDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Cure.
 */
@RestController
@RequestMapping("/api")
public class CureResource {

    private final Logger log = LoggerFactory.getLogger(CureResource.class);

    private static final String ENTITY_NAME = "cure";

    private final CureService cureService;

    public CureResource(CureService cureService) {
        this.cureService = cureService;
    }

    /**
     * POST  /cures : Create a new cure.
     *
     * @param cureDTO the cureDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new cureDTO, or with status 400 (Bad Request) if the cure has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/cures")
    @Timed
    public ResponseEntity<CureDTO> createCure(@RequestBody CureDTO cureDTO) throws URISyntaxException {
        log.debug("REST request to save Cure : {}", cureDTO);
        if (cureDTO.getId() != null) {
            throw new BadRequestAlertException("A new cure cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CureDTO result = cureService.save(cureDTO);
        return ResponseEntity.created(new URI("/api/cures/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /cures : Updates an existing cure.
     *
     * @param cureDTO the cureDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated cureDTO,
     * or with status 400 (Bad Request) if the cureDTO is not valid,
     * or with status 500 (Internal Server Error) if the cureDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/cures")
    @Timed
    public ResponseEntity<CureDTO> updateCure(@RequestBody CureDTO cureDTO) throws URISyntaxException {
        log.debug("REST request to update Cure : {}", cureDTO);
        if (cureDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CureDTO result = cureService.save(cureDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, cureDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /cures : get all the cures.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of cures in body
     */
    @GetMapping("/cures")
    @Timed
    public ResponseEntity<List<CureDTO>> getAllCures(Pageable pageable) {
        log.debug("REST request to get a page of Cures");
        Page<CureDTO> page = cureService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/cures");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /cures/:id : get the "id" cure.
     *
     * @param id the id of the cureDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the cureDTO, or with status 404 (Not Found)
     */
    @GetMapping("/cures/{id}")
    @Timed
    public ResponseEntity<CureDTO> getCure(@PathVariable Long id) {
        log.debug("REST request to get Cure : {}", id);
        Optional<CureDTO> cureDTO = cureService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cureDTO);
    }

    /**
     * DELETE  /cures/:id : delete the "id" cure.
     *
     * @param id the id of the cureDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/cures/{id}")
    @Timed
    public ResponseEntity<Void> deleteCure(@PathVariable Long id) {
        log.debug("REST request to delete Cure : {}", id);
        cureService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
