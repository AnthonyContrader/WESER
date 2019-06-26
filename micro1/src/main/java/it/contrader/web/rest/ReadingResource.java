package it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.service.ReadingService;
import it.contrader.web.rest.errors.BadRequestAlertException;
import it.contrader.web.rest.util.HeaderUtil;
import it.contrader.web.rest.util.PaginationUtil;
import it.contrader.service.dto.ReadingDTO;
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
 * REST controller for managing Reading.
 */
@RestController
@RequestMapping("/api")
public class ReadingResource {

    private final Logger log = LoggerFactory.getLogger(ReadingResource.class);

    private static final String ENTITY_NAME = "reading";

    private final ReadingService readingService;

    public ReadingResource(ReadingService readingService) {
        this.readingService = readingService;
    }

    /**
     * POST  /readings : Create a new reading.
     *
     * @param readingDTO the readingDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new readingDTO, or with status 400 (Bad Request) if the reading has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/readings")
    @Timed
    public ResponseEntity<ReadingDTO> createReading(@RequestBody ReadingDTO readingDTO) throws URISyntaxException {
        log.debug("REST request to save Reading : {}", readingDTO);
        if (readingDTO.getId() != null) {
            throw new BadRequestAlertException("A new reading cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReadingDTO result = readingService.save(readingDTO);
        return ResponseEntity.created(new URI("/api/readings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /readings : Updates an existing reading.
     *
     * @param readingDTO the readingDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated readingDTO,
     * or with status 400 (Bad Request) if the readingDTO is not valid,
     * or with status 500 (Internal Server Error) if the readingDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/readings")
    @Timed
    public ResponseEntity<ReadingDTO> updateReading(@RequestBody ReadingDTO readingDTO) throws URISyntaxException {
        log.debug("REST request to update Reading : {}", readingDTO);
        if (readingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReadingDTO result = readingService.save(readingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, readingDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /readings : get all the readings.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of readings in body
     */
    @GetMapping("/readings")
    @Timed
    public ResponseEntity<List<ReadingDTO>> getAllReadings(Pageable pageable) {
        log.debug("REST request to get a page of Readings");
        Page<ReadingDTO> page = readingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/readings");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /readings/:id : get the "id" reading.
     *
     * @param id the id of the readingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the readingDTO, or with status 404 (Not Found)
     */
    @GetMapping("/readings/{id}")
    @Timed
    public ResponseEntity<ReadingDTO> getReading(@PathVariable Long id) {
        log.debug("REST request to get Reading : {}", id);
        Optional<ReadingDTO> readingDTO = readingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(readingDTO);
    }

    /**
     * DELETE  /readings/:id : delete the "id" reading.
     *
     * @param id the id of the readingDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/readings/{id}")
    @Timed
    public ResponseEntity<Void> deleteReading(@PathVariable Long id) {
        log.debug("REST request to delete Reading : {}", id);
        readingService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
