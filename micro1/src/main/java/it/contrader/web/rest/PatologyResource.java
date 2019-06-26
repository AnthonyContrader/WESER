package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.PatologyService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.web.rest.util.PaginationUtil;
import it.contrader.service.dto.PatologyDTO;
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
 * REST controller for managing Patology.
 */
@RestController
@RequestMapping("/api")
public class PatologyResource {

    private final Logger log = LoggerFactory.getLogger(PatologyResource.class);

    private static final String ENTITY_NAME = "patology";

    private final PatologyService patologyService;

    public PatologyResource(PatologyService patologyService) {
        this.patologyService = patologyService;
    }

    /**
     * POST  /patologies : Create a new patology.
     *
     * @param patologyDTO the patologyDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new patologyDTO, or with status 400 (Bad Request) if the patology has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/patologies")
    @Timed
    public ResponseEntity<PatologyDTO> createPatology(@RequestBody PatologyDTO patologyDTO) throws URISyntaxException {
        log.debug("REST request to save Patology : {}", patologyDTO);
        if (patologyDTO.getId() != null) {
            throw new BadRequestAlertException("A new patology cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PatologyDTO result = patologyService.save(patologyDTO);
        return ResponseEntity.created(new URI("/api/patologies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /patologies : Updates an existing patology.
     *
     * @param patologyDTO the patologyDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated patologyDTO,
     * or with status 400 (Bad Request) if the patologyDTO is not valid,
     * or with status 500 (Internal Server Error) if the patologyDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/patologies")
    @Timed
    public ResponseEntity<PatologyDTO> updatePatology(@RequestBody PatologyDTO patologyDTO) throws URISyntaxException {
        log.debug("REST request to update Patology : {}", patologyDTO);
        if (patologyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PatologyDTO result = patologyService.save(patologyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, patologyDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /patologies : get all the patologies.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of patologies in body
     */
    @GetMapping("/patologies")
    @Timed
    public ResponseEntity<List<PatologyDTO>> getAllPatologies(Pageable pageable) {
        log.debug("REST request to get a page of Patologies");
        Page<PatologyDTO> page = patologyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/patologies");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /patologies/:id : get the "id" patology.
     *
     * @param id the id of the patologyDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the patologyDTO, or with status 404 (Not Found)
     */
    @GetMapping("/patologies/{id}")
    @Timed
    public ResponseEntity<PatologyDTO> getPatology(@PathVariable Long id) {
        log.debug("REST request to get Patology : {}", id);
        Optional<PatologyDTO> patologyDTO = patologyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(patologyDTO);
    }

    /**
     * DELETE  /patologies/:id : delete the "id" patology.
     *
     * @param id the id of the patologyDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/patologies/{id}")
    @Timed
    public ResponseEntity<Void> deletePatology(@PathVariable Long id) {
        log.debug("REST request to delete Patology : {}", id);
        patologyService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
