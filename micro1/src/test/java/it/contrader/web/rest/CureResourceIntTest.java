package it.contrader.web.rest;

import it.contrader.Micro1App;

import it.contrader.domain.Cure;
import it.contrader.repository.CureRepository;
import it.contrader.service.CureService;
import it.contrader.service.dto.CureDTO;
import it.contrader.service.mapper.CureMapper;
import it.contrader.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static it.contrader.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the CureResource REST controller.
 *
 * @see CureResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro1App.class)
public class CureResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CF = "AAAAAAAAAA";
    private static final String UPDATED_CF = "BBBBBBBBBB";

    private static final Integer DEFAULT_AGE = 1;
    private static final Integer UPDATED_AGE = 2;

    private static final String DEFAULT_PATO = "AAAAAAAAAA";
    private static final String UPDATED_PATO = "BBBBBBBBBB";

    private static final String DEFAULT_CARENAME = "AAAAAAAAAA";
    private static final String UPDATED_CARENAME = "BBBBBBBBBB";

    private static final String DEFAULT_QUANTITY = "AAAAAAAAAA";
    private static final String UPDATED_QUANTITY = "BBBBBBBBBB";

    private static final String DEFAULT_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_NOTES = "BBBBBBBBBB";

    @Autowired
    private CureRepository cureRepository;


    @Autowired
    private CureMapper cureMapper;
    

    @Autowired
    private CureService cureService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restCureMockMvc;

    private Cure cure;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CureResource cureResource = new CureResource(cureService);
        this.restCureMockMvc = MockMvcBuilders.standaloneSetup(cureResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Cure createEntity(EntityManager em) {
        Cure cure = new Cure()
            .name(DEFAULT_NAME)
            .cf(DEFAULT_CF)
            .age(DEFAULT_AGE)
            .pato(DEFAULT_PATO)
            .carename(DEFAULT_CARENAME)
            .quantity(DEFAULT_QUANTITY)
            .notes(DEFAULT_NOTES);
        return cure;
    }

    @Before
    public void initTest() {
        cure = createEntity(em);
    }

    @Test
    @Transactional
    public void createCure() throws Exception {
        int databaseSizeBeforeCreate = cureRepository.findAll().size();

        // Create the Cure
        CureDTO cureDTO = cureMapper.toDto(cure);
        restCureMockMvc.perform(post("/api/cures")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cureDTO)))
            .andExpect(status().isCreated());

        // Validate the Cure in the database
        List<Cure> cureList = cureRepository.findAll();
        assertThat(cureList).hasSize(databaseSizeBeforeCreate + 1);
        Cure testCure = cureList.get(cureList.size() - 1);
        assertThat(testCure.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testCure.getCf()).isEqualTo(DEFAULT_CF);
        assertThat(testCure.getAge()).isEqualTo(DEFAULT_AGE);
        assertThat(testCure.getPato()).isEqualTo(DEFAULT_PATO);
        assertThat(testCure.getCarename()).isEqualTo(DEFAULT_CARENAME);
        assertThat(testCure.getQuantity()).isEqualTo(DEFAULT_QUANTITY);
        assertThat(testCure.getNotes()).isEqualTo(DEFAULT_NOTES);
    }

    @Test
    @Transactional
    public void createCureWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = cureRepository.findAll().size();

        // Create the Cure with an existing ID
        cure.setId(1L);
        CureDTO cureDTO = cureMapper.toDto(cure);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCureMockMvc.perform(post("/api/cures")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cureDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Cure in the database
        List<Cure> cureList = cureRepository.findAll();
        assertThat(cureList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllCures() throws Exception {
        // Initialize the database
        cureRepository.saveAndFlush(cure);

        // Get all the cureList
        restCureMockMvc.perform(get("/api/cures?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cure.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].cf").value(hasItem(DEFAULT_CF.toString())))
            .andExpect(jsonPath("$.[*].age").value(hasItem(DEFAULT_AGE)))
            .andExpect(jsonPath("$.[*].pato").value(hasItem(DEFAULT_PATO.toString())))
            .andExpect(jsonPath("$.[*].carename").value(hasItem(DEFAULT_CARENAME.toString())))
            .andExpect(jsonPath("$.[*].quantity").value(hasItem(DEFAULT_QUANTITY.toString())))
            .andExpect(jsonPath("$.[*].notes").value(hasItem(DEFAULT_NOTES.toString())));
    }
    

    @Test
    @Transactional
    public void getCure() throws Exception {
        // Initialize the database
        cureRepository.saveAndFlush(cure);

        // Get the cure
        restCureMockMvc.perform(get("/api/cures/{id}", cure.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cure.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.cf").value(DEFAULT_CF.toString()))
            .andExpect(jsonPath("$.age").value(DEFAULT_AGE))
            .andExpect(jsonPath("$.pato").value(DEFAULT_PATO.toString()))
            .andExpect(jsonPath("$.carename").value(DEFAULT_CARENAME.toString()))
            .andExpect(jsonPath("$.quantity").value(DEFAULT_QUANTITY.toString()))
            .andExpect(jsonPath("$.notes").value(DEFAULT_NOTES.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingCure() throws Exception {
        // Get the cure
        restCureMockMvc.perform(get("/api/cures/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCure() throws Exception {
        // Initialize the database
        cureRepository.saveAndFlush(cure);

        int databaseSizeBeforeUpdate = cureRepository.findAll().size();

        // Update the cure
        Cure updatedCure = cureRepository.findById(cure.getId()).get();
        // Disconnect from session so that the updates on updatedCure are not directly saved in db
        em.detach(updatedCure);
        updatedCure
            .name(UPDATED_NAME)
            .cf(UPDATED_CF)
            .age(UPDATED_AGE)
            .pato(UPDATED_PATO)
            .carename(UPDATED_CARENAME)
            .quantity(UPDATED_QUANTITY)
            .notes(UPDATED_NOTES);
        CureDTO cureDTO = cureMapper.toDto(updatedCure);

        restCureMockMvc.perform(put("/api/cures")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cureDTO)))
            .andExpect(status().isOk());

        // Validate the Cure in the database
        List<Cure> cureList = cureRepository.findAll();
        assertThat(cureList).hasSize(databaseSizeBeforeUpdate);
        Cure testCure = cureList.get(cureList.size() - 1);
        assertThat(testCure.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testCure.getCf()).isEqualTo(UPDATED_CF);
        assertThat(testCure.getAge()).isEqualTo(UPDATED_AGE);
        assertThat(testCure.getPato()).isEqualTo(UPDATED_PATO);
        assertThat(testCure.getCarename()).isEqualTo(UPDATED_CARENAME);
        assertThat(testCure.getQuantity()).isEqualTo(UPDATED_QUANTITY);
        assertThat(testCure.getNotes()).isEqualTo(UPDATED_NOTES);
    }

    @Test
    @Transactional
    public void updateNonExistingCure() throws Exception {
        int databaseSizeBeforeUpdate = cureRepository.findAll().size();

        // Create the Cure
        CureDTO cureDTO = cureMapper.toDto(cure);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restCureMockMvc.perform(put("/api/cures")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cureDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Cure in the database
        List<Cure> cureList = cureRepository.findAll();
        assertThat(cureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCure() throws Exception {
        // Initialize the database
        cureRepository.saveAndFlush(cure);

        int databaseSizeBeforeDelete = cureRepository.findAll().size();

        // Get the cure
        restCureMockMvc.perform(delete("/api/cures/{id}", cure.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Cure> cureList = cureRepository.findAll();
        assertThat(cureList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Cure.class);
        Cure cure1 = new Cure();
        cure1.setId(1L);
        Cure cure2 = new Cure();
        cure2.setId(cure1.getId());
        assertThat(cure1).isEqualTo(cure2);
        cure2.setId(2L);
        assertThat(cure1).isNotEqualTo(cure2);
        cure1.setId(null);
        assertThat(cure1).isNotEqualTo(cure2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CureDTO.class);
        CureDTO cureDTO1 = new CureDTO();
        cureDTO1.setId(1L);
        CureDTO cureDTO2 = new CureDTO();
        assertThat(cureDTO1).isNotEqualTo(cureDTO2);
        cureDTO2.setId(cureDTO1.getId());
        assertThat(cureDTO1).isEqualTo(cureDTO2);
        cureDTO2.setId(2L);
        assertThat(cureDTO1).isNotEqualTo(cureDTO2);
        cureDTO1.setId(null);
        assertThat(cureDTO1).isNotEqualTo(cureDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(cureMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(cureMapper.fromId(null)).isNull();
    }
}
