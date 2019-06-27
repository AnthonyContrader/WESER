package it.contrader.web.rest;

import it.contrader.Micro1App;

import it.contrader.domain.Reading;
import it.contrader.repository.ReadingRepository;
import it.contrader.service.ReadingService;
import it.contrader.service.dto.ReadingDTO;
import it.contrader.service.mapper.ReadingMapper;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


import static it.contrader.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ReadingResource REST controller.
 *
 * @see ReadingResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro1App.class)
public class ReadingResourceIntTest {

    private static final String DEFAULT_CF = "AAAAAAAAAA";
    private static final String UPDATED_CF = "BBBBBBBBBB";

    private static final String DEFAULT_RD = "AAAAAAAAAA";
    private static final String UPDATED_RD = "BBBBBBBBBB";

    private static final Integer DEFAULT_MP = 1;
    private static final Integer UPDATED_MP = 2;

    private static final Integer DEFAULT_MPR = 1;
    private static final Integer UPDATED_MPR = 2;

    private static final Integer DEFAULT_CIR = 1;
    private static final Integer UPDATED_CIR = 2;

    private static final Integer DEFAULT_BRE = 1;
    private static final Integer UPDATED_BRE = 2;

    private static final Float DEFAULT_TEMP = 1F;
    private static final Float UPDATED_TEMP = 2F;

    private static final LocalDate DEFAULT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private ReadingRepository readingRepository;


    @Autowired
    private ReadingMapper readingMapper;
    

    @Autowired
    private ReadingService readingService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restReadingMockMvc;

    private Reading reading;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ReadingResource readingResource = new ReadingResource(readingService);
        this.restReadingMockMvc = MockMvcBuilders.standaloneSetup(readingResource)
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
    public static Reading createEntity(EntityManager em) {
        Reading reading = new Reading()
            .cf(DEFAULT_CF)
            .rd(DEFAULT_RD)
            .mp(DEFAULT_MP)
            .mpr(DEFAULT_MPR)
            .cir(DEFAULT_CIR)
            .bre(DEFAULT_BRE)
            .temp(DEFAULT_TEMP)
            .date(DEFAULT_DATE);
        return reading;
    }

    @Before
    public void initTest() {
        reading = createEntity(em);
    }

    @Test
    @Transactional
    public void createReading() throws Exception {
        int databaseSizeBeforeCreate = readingRepository.findAll().size();

        // Create the Reading
        ReadingDTO readingDTO = readingMapper.toDto(reading);
        restReadingMockMvc.perform(post("/api/readings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(readingDTO)))
            .andExpect(status().isCreated());

        // Validate the Reading in the database
        List<Reading> readingList = readingRepository.findAll();
        assertThat(readingList).hasSize(databaseSizeBeforeCreate + 1);
        Reading testReading = readingList.get(readingList.size() - 1);
        assertThat(testReading.getCf()).isEqualTo(DEFAULT_CF);
        assertThat(testReading.getRd()).isEqualTo(DEFAULT_RD);
        assertThat(testReading.getMp()).isEqualTo(DEFAULT_MP);
        assertThat(testReading.getMpr()).isEqualTo(DEFAULT_MPR);
        assertThat(testReading.getCir()).isEqualTo(DEFAULT_CIR);
        assertThat(testReading.getBre()).isEqualTo(DEFAULT_BRE);
        assertThat(testReading.getTemp()).isEqualTo(DEFAULT_TEMP);
        assertThat(testReading.getDate()).isEqualTo(DEFAULT_DATE);
    }

    @Test
    @Transactional
    public void createReadingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = readingRepository.findAll().size();

        // Create the Reading with an existing ID
        reading.setId(1L);
        ReadingDTO readingDTO = readingMapper.toDto(reading);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReadingMockMvc.perform(post("/api/readings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(readingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Reading in the database
        List<Reading> readingList = readingRepository.findAll();
        assertThat(readingList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllReadings() throws Exception {
        // Initialize the database
        readingRepository.saveAndFlush(reading);

        // Get all the readingList
        restReadingMockMvc.perform(get("/api/readings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reading.getId().intValue())))
            .andExpect(jsonPath("$.[*].cf").value(hasItem(DEFAULT_CF.toString())))
            .andExpect(jsonPath("$.[*].rd").value(hasItem(DEFAULT_RD.toString())))
            .andExpect(jsonPath("$.[*].mp").value(hasItem(DEFAULT_MP)))
            .andExpect(jsonPath("$.[*].mpr").value(hasItem(DEFAULT_MPR)))
            .andExpect(jsonPath("$.[*].cir").value(hasItem(DEFAULT_CIR)))
            .andExpect(jsonPath("$.[*].bre").value(hasItem(DEFAULT_BRE)))
            .andExpect(jsonPath("$.[*].temp").value(hasItem(DEFAULT_TEMP.doubleValue())))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())));
    }
    

    @Test
    @Transactional
    public void getReading() throws Exception {
        // Initialize the database
        readingRepository.saveAndFlush(reading);

        // Get the reading
        restReadingMockMvc.perform(get("/api/readings/{id}", reading.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(reading.getId().intValue()))
            .andExpect(jsonPath("$.cf").value(DEFAULT_CF.toString()))
            .andExpect(jsonPath("$.rd").value(DEFAULT_RD.toString()))
            .andExpect(jsonPath("$.mp").value(DEFAULT_MP))
            .andExpect(jsonPath("$.mpr").value(DEFAULT_MPR))
            .andExpect(jsonPath("$.cir").value(DEFAULT_CIR))
            .andExpect(jsonPath("$.bre").value(DEFAULT_BRE))
            .andExpect(jsonPath("$.temp").value(DEFAULT_TEMP.doubleValue()))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingReading() throws Exception {
        // Get the reading
        restReadingMockMvc.perform(get("/api/readings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReading() throws Exception {
        // Initialize the database
        readingRepository.saveAndFlush(reading);

        int databaseSizeBeforeUpdate = readingRepository.findAll().size();

        // Update the reading
        Reading updatedReading = readingRepository.findById(reading.getId()).get();
        // Disconnect from session so that the updates on updatedReading are not directly saved in db
        em.detach(updatedReading);
        updatedReading
            .cf(UPDATED_CF)
            .rd(UPDATED_RD)
            .mp(UPDATED_MP)
            .mpr(UPDATED_MPR)
            .cir(UPDATED_CIR)
            .bre(UPDATED_BRE)
            .temp(UPDATED_TEMP)
            .date(UPDATED_DATE);
        ReadingDTO readingDTO = readingMapper.toDto(updatedReading);

        restReadingMockMvc.perform(put("/api/readings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(readingDTO)))
            .andExpect(status().isOk());

        // Validate the Reading in the database
        List<Reading> readingList = readingRepository.findAll();
        assertThat(readingList).hasSize(databaseSizeBeforeUpdate);
        Reading testReading = readingList.get(readingList.size() - 1);
        assertThat(testReading.getCf()).isEqualTo(UPDATED_CF);
        assertThat(testReading.getRd()).isEqualTo(UPDATED_RD);
        assertThat(testReading.getMp()).isEqualTo(UPDATED_MP);
        assertThat(testReading.getMpr()).isEqualTo(UPDATED_MPR);
        assertThat(testReading.getCir()).isEqualTo(UPDATED_CIR);
        assertThat(testReading.getBre()).isEqualTo(UPDATED_BRE);
        assertThat(testReading.getTemp()).isEqualTo(UPDATED_TEMP);
        assertThat(testReading.getDate()).isEqualTo(UPDATED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingReading() throws Exception {
        int databaseSizeBeforeUpdate = readingRepository.findAll().size();

        // Create the Reading
        ReadingDTO readingDTO = readingMapper.toDto(reading);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restReadingMockMvc.perform(put("/api/readings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(readingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Reading in the database
        List<Reading> readingList = readingRepository.findAll();
        assertThat(readingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteReading() throws Exception {
        // Initialize the database
        readingRepository.saveAndFlush(reading);

        int databaseSizeBeforeDelete = readingRepository.findAll().size();

        // Get the reading
        restReadingMockMvc.perform(delete("/api/readings/{id}", reading.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Reading> readingList = readingRepository.findAll();
        assertThat(readingList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Reading.class);
        Reading reading1 = new Reading();
        reading1.setId(1L);
        Reading reading2 = new Reading();
        reading2.setId(reading1.getId());
        assertThat(reading1).isEqualTo(reading2);
        reading2.setId(2L);
        assertThat(reading1).isNotEqualTo(reading2);
        reading1.setId(null);
        assertThat(reading1).isNotEqualTo(reading2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReadingDTO.class);
        ReadingDTO readingDTO1 = new ReadingDTO();
        readingDTO1.setId(1L);
        ReadingDTO readingDTO2 = new ReadingDTO();
        assertThat(readingDTO1).isNotEqualTo(readingDTO2);
        readingDTO2.setId(readingDTO1.getId());
        assertThat(readingDTO1).isEqualTo(readingDTO2);
        readingDTO2.setId(2L);
        assertThat(readingDTO1).isNotEqualTo(readingDTO2);
        readingDTO1.setId(null);
        assertThat(readingDTO1).isNotEqualTo(readingDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(readingMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(readingMapper.fromId(null)).isNull();
    }
}
