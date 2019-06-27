package it.contrader.web.rest;

import it.contrader.Micro1App;

import it.contrader.domain.Patology;
import it.contrader.repository.PatologyRepository;
import it.contrader.service.PatologyService;
import it.contrader.service.dto.PatologyDTO;
import it.contrader.service.mapper.PatologyMapper;
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
 * Test class for the PatologyResource REST controller.
 *
 * @see PatologyResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro1App.class)
public class PatologyResourceIntTest {

    private static final String DEFAULT_PATO = "AAAAAAAAAA";
    private static final String UPDATED_PATO = "BBBBBBBBBB";

    private static final String DEFAULT_CARENAME = "AAAAAAAAAA";
    private static final String UPDATED_CARENAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_MP = 1;
    private static final Integer UPDATED_MP = 2;

    private static final Integer DEFAULT_MPR = 1;
    private static final Integer UPDATED_MPR = 2;

    private static final Integer DEFAULT_MC = 1;
    private static final Integer UPDATED_MC = 2;

    private static final Integer DEFAULT_MCI = 1;
    private static final Integer UPDATED_MCI = 2;

    private static final Integer DEFAULT_MB = 1;
    private static final Integer UPDATED_MB = 2;

    private static final Integer DEFAULT_MBR = 1;
    private static final Integer UPDATED_MBR = 2;

    private static final Float DEFAULT_MT = 1F;
    private static final Float UPDATED_MT = 2F;

    private static final Float DEFAULT_MTE = 1F;
    private static final Float UPDATED_MTE = 2F;

    private static final String DEFAULT_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_NOTES = "BBBBBBBBBB";

    @Autowired
    private PatologyRepository patologyRepository;


    @Autowired
    private PatologyMapper patologyMapper;
    

    @Autowired
    private PatologyService patologyService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restPatologyMockMvc;

    private Patology patology;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final PatologyResource patologyResource = new PatologyResource(patologyService);
        this.restPatologyMockMvc = MockMvcBuilders.standaloneSetup(patologyResource)
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
    public static Patology createEntity(EntityManager em) {
        Patology patology = new Patology()
            .pato(DEFAULT_PATO)
            .carename(DEFAULT_CARENAME)
            .mp(DEFAULT_MP)
            .mpr(DEFAULT_MPR)
            .mc(DEFAULT_MC)
            .mci(DEFAULT_MCI)
            .mb(DEFAULT_MB)
            .mbr(DEFAULT_MBR)
            .mt(DEFAULT_MT)
            .mte(DEFAULT_MTE)
            .notes(DEFAULT_NOTES);
        return patology;
    }

    @Before
    public void initTest() {
        patology = createEntity(em);
    }

    @Test
    @Transactional
    public void createPatology() throws Exception {
        int databaseSizeBeforeCreate = patologyRepository.findAll().size();

        // Create the Patology
        PatologyDTO patologyDTO = patologyMapper.toDto(patology);
        restPatologyMockMvc.perform(post("/api/patologies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(patologyDTO)))
            .andExpect(status().isCreated());

        // Validate the Patology in the database
        List<Patology> patologyList = patologyRepository.findAll();
        assertThat(patologyList).hasSize(databaseSizeBeforeCreate + 1);
        Patology testPatology = patologyList.get(patologyList.size() - 1);
        assertThat(testPatology.getPato()).isEqualTo(DEFAULT_PATO);
        assertThat(testPatology.getCarename()).isEqualTo(DEFAULT_CARENAME);
        assertThat(testPatology.getMp()).isEqualTo(DEFAULT_MP);
        assertThat(testPatology.getMpr()).isEqualTo(DEFAULT_MPR);
        assertThat(testPatology.getMc()).isEqualTo(DEFAULT_MC);
        assertThat(testPatology.getMci()).isEqualTo(DEFAULT_MCI);
        assertThat(testPatology.getMb()).isEqualTo(DEFAULT_MB);
        assertThat(testPatology.getMbr()).isEqualTo(DEFAULT_MBR);
        assertThat(testPatology.getMt()).isEqualTo(DEFAULT_MT);
        assertThat(testPatology.getMte()).isEqualTo(DEFAULT_MTE);
        assertThat(testPatology.getNotes()).isEqualTo(DEFAULT_NOTES);
    }

    @Test
    @Transactional
    public void createPatologyWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = patologyRepository.findAll().size();

        // Create the Patology with an existing ID
        patology.setId(1L);
        PatologyDTO patologyDTO = patologyMapper.toDto(patology);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPatologyMockMvc.perform(post("/api/patologies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(patologyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Patology in the database
        List<Patology> patologyList = patologyRepository.findAll();
        assertThat(patologyList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllPatologies() throws Exception {
        // Initialize the database
        patologyRepository.saveAndFlush(patology);

        // Get all the patologyList
        restPatologyMockMvc.perform(get("/api/patologies?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(patology.getId().intValue())))
            .andExpect(jsonPath("$.[*].pato").value(hasItem(DEFAULT_PATO.toString())))
            .andExpect(jsonPath("$.[*].carename").value(hasItem(DEFAULT_CARENAME.toString())))
            .andExpect(jsonPath("$.[*].mp").value(hasItem(DEFAULT_MP)))
            .andExpect(jsonPath("$.[*].mpr").value(hasItem(DEFAULT_MPR)))
            .andExpect(jsonPath("$.[*].mc").value(hasItem(DEFAULT_MC)))
            .andExpect(jsonPath("$.[*].mci").value(hasItem(DEFAULT_MCI)))
            .andExpect(jsonPath("$.[*].mb").value(hasItem(DEFAULT_MB)))
            .andExpect(jsonPath("$.[*].mbr").value(hasItem(DEFAULT_MBR)))
            .andExpect(jsonPath("$.[*].mt").value(hasItem(DEFAULT_MT.doubleValue())))
            .andExpect(jsonPath("$.[*].mte").value(hasItem(DEFAULT_MTE.doubleValue())))
            .andExpect(jsonPath("$.[*].notes").value(hasItem(DEFAULT_NOTES.toString())));
    }
    

    @Test
    @Transactional
    public void getPatology() throws Exception {
        // Initialize the database
        patologyRepository.saveAndFlush(patology);

        // Get the patology
        restPatologyMockMvc.perform(get("/api/patologies/{id}", patology.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(patology.getId().intValue()))
            .andExpect(jsonPath("$.pato").value(DEFAULT_PATO.toString()))
            .andExpect(jsonPath("$.carename").value(DEFAULT_CARENAME.toString()))
            .andExpect(jsonPath("$.mp").value(DEFAULT_MP))
            .andExpect(jsonPath("$.mpr").value(DEFAULT_MPR))
            .andExpect(jsonPath("$.mc").value(DEFAULT_MC))
            .andExpect(jsonPath("$.mci").value(DEFAULT_MCI))
            .andExpect(jsonPath("$.mb").value(DEFAULT_MB))
            .andExpect(jsonPath("$.mbr").value(DEFAULT_MBR))
            .andExpect(jsonPath("$.mt").value(DEFAULT_MT.doubleValue()))
            .andExpect(jsonPath("$.mte").value(DEFAULT_MTE.doubleValue()))
            .andExpect(jsonPath("$.notes").value(DEFAULT_NOTES.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingPatology() throws Exception {
        // Get the patology
        restPatologyMockMvc.perform(get("/api/patologies/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePatology() throws Exception {
        // Initialize the database
        patologyRepository.saveAndFlush(patology);

        int databaseSizeBeforeUpdate = patologyRepository.findAll().size();

        // Update the patology
        Patology updatedPatology = patologyRepository.findById(patology.getId()).get();
        // Disconnect from session so that the updates on updatedPatology are not directly saved in db
        em.detach(updatedPatology);
        updatedPatology
            .pato(UPDATED_PATO)
            .carename(UPDATED_CARENAME)
            .mp(UPDATED_MP)
            .mpr(UPDATED_MPR)
            .mc(UPDATED_MC)
            .mci(UPDATED_MCI)
            .mb(UPDATED_MB)
            .mbr(UPDATED_MBR)
            .mt(UPDATED_MT)
            .mte(UPDATED_MTE)
            .notes(UPDATED_NOTES);
        PatologyDTO patologyDTO = patologyMapper.toDto(updatedPatology);

        restPatologyMockMvc.perform(put("/api/patologies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(patologyDTO)))
            .andExpect(status().isOk());

        // Validate the Patology in the database
        List<Patology> patologyList = patologyRepository.findAll();
        assertThat(patologyList).hasSize(databaseSizeBeforeUpdate);
        Patology testPatology = patologyList.get(patologyList.size() - 1);
        assertThat(testPatology.getPato()).isEqualTo(UPDATED_PATO);
        assertThat(testPatology.getCarename()).isEqualTo(UPDATED_CARENAME);
        assertThat(testPatology.getMp()).isEqualTo(UPDATED_MP);
        assertThat(testPatology.getMpr()).isEqualTo(UPDATED_MPR);
        assertThat(testPatology.getMc()).isEqualTo(UPDATED_MC);
        assertThat(testPatology.getMci()).isEqualTo(UPDATED_MCI);
        assertThat(testPatology.getMb()).isEqualTo(UPDATED_MB);
        assertThat(testPatology.getMbr()).isEqualTo(UPDATED_MBR);
        assertThat(testPatology.getMt()).isEqualTo(UPDATED_MT);
        assertThat(testPatology.getMte()).isEqualTo(UPDATED_MTE);
        assertThat(testPatology.getNotes()).isEqualTo(UPDATED_NOTES);
    }

    @Test
    @Transactional
    public void updateNonExistingPatology() throws Exception {
        int databaseSizeBeforeUpdate = patologyRepository.findAll().size();

        // Create the Patology
        PatologyDTO patologyDTO = patologyMapper.toDto(patology);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restPatologyMockMvc.perform(put("/api/patologies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(patologyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Patology in the database
        List<Patology> patologyList = patologyRepository.findAll();
        assertThat(patologyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePatology() throws Exception {
        // Initialize the database
        patologyRepository.saveAndFlush(patology);

        int databaseSizeBeforeDelete = patologyRepository.findAll().size();

        // Get the patology
        restPatologyMockMvc.perform(delete("/api/patologies/{id}", patology.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Patology> patologyList = patologyRepository.findAll();
        assertThat(patologyList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Patology.class);
        Patology patology1 = new Patology();
        patology1.setId(1L);
        Patology patology2 = new Patology();
        patology2.setId(patology1.getId());
        assertThat(patology1).isEqualTo(patology2);
        patology2.setId(2L);
        assertThat(patology1).isNotEqualTo(patology2);
        patology1.setId(null);
        assertThat(patology1).isNotEqualTo(patology2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PatologyDTO.class);
        PatologyDTO patologyDTO1 = new PatologyDTO();
        patologyDTO1.setId(1L);
        PatologyDTO patologyDTO2 = new PatologyDTO();
        assertThat(patologyDTO1).isNotEqualTo(patologyDTO2);
        patologyDTO2.setId(patologyDTO1.getId());
        assertThat(patologyDTO1).isEqualTo(patologyDTO2);
        patologyDTO2.setId(2L);
        assertThat(patologyDTO1).isNotEqualTo(patologyDTO2);
        patologyDTO1.setId(null);
        assertThat(patologyDTO1).isNotEqualTo(patologyDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(patologyMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(patologyMapper.fromId(null)).isNull();
    }
}
