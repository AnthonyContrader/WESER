package it.contrader.web.rest;

import it.contrader.Micro1App;

import it.contrader.domain.Emergency;
import it.contrader.repository.EmergencyRepository;
import it.contrader.service.EmergencyService;
import it.contrader.service.dto.EmergencyDTO;
import it.contrader.service.mapper.EmergencyMapper;
import it.contrader.web.rest.errors.ExceptionTranslator;
import it.contrader.service.dto.EmergencyCriteria;
import it.contrader.service.EmergencyQueryService;

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
 * Test class for the EmergencyResource REST controller.
 *
 * @see EmergencyResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro1App.class)
public class EmergencyResourceIntTest {

    private static final String DEFAULT_NUM = "AAAAAAAAAA";
    private static final String UPDATED_NUM = "BBBBBBBBBB";

    @Autowired
    private EmergencyRepository emergencyRepository;


    @Autowired
    private EmergencyMapper emergencyMapper;
    

    @Autowired
    private EmergencyService emergencyService;

    @Autowired
    private EmergencyQueryService emergencyQueryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restEmergencyMockMvc;

    private Emergency emergency;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final EmergencyResource emergencyResource = new EmergencyResource(emergencyService, emergencyQueryService);
        this.restEmergencyMockMvc = MockMvcBuilders.standaloneSetup(emergencyResource)
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
    public static Emergency createEntity(EntityManager em) {
        Emergency emergency = new Emergency()
            .num(DEFAULT_NUM);
        return emergency;
    }

    @Before
    public void initTest() {
        emergency = createEntity(em);
    }

    @Test
    @Transactional
    public void createEmergency() throws Exception {
        int databaseSizeBeforeCreate = emergencyRepository.findAll().size();

        // Create the Emergency
        EmergencyDTO emergencyDTO = emergencyMapper.toDto(emergency);
        restEmergencyMockMvc.perform(post("/api/emergencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emergencyDTO)))
            .andExpect(status().isCreated());

        // Validate the Emergency in the database
        List<Emergency> emergencyList = emergencyRepository.findAll();
        assertThat(emergencyList).hasSize(databaseSizeBeforeCreate + 1);
        Emergency testEmergency = emergencyList.get(emergencyList.size() - 1);
        assertThat(testEmergency.getNum()).isEqualTo(DEFAULT_NUM);
    }

    @Test
    @Transactional
    public void createEmergencyWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = emergencyRepository.findAll().size();

        // Create the Emergency with an existing ID
        emergency.setId(1L);
        EmergencyDTO emergencyDTO = emergencyMapper.toDto(emergency);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEmergencyMockMvc.perform(post("/api/emergencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emergencyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Emergency in the database
        List<Emergency> emergencyList = emergencyRepository.findAll();
        assertThat(emergencyList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllEmergencies() throws Exception {
        // Initialize the database
        emergencyRepository.saveAndFlush(emergency);

        // Get all the emergencyList
        restEmergencyMockMvc.perform(get("/api/emergencies?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(emergency.getId().intValue())))
            .andExpect(jsonPath("$.[*].num").value(hasItem(DEFAULT_NUM.toString())));
    }
    

    @Test
    @Transactional
    public void getEmergency() throws Exception {
        // Initialize the database
        emergencyRepository.saveAndFlush(emergency);

        // Get the emergency
        restEmergencyMockMvc.perform(get("/api/emergencies/{id}", emergency.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(emergency.getId().intValue()))
            .andExpect(jsonPath("$.num").value(DEFAULT_NUM.toString()));
    }

    @Test
    @Transactional
    public void getAllEmergenciesByNumIsEqualToSomething() throws Exception {
        // Initialize the database
        emergencyRepository.saveAndFlush(emergency);

        // Get all the emergencyList where num equals to DEFAULT_NUM
        defaultEmergencyShouldBeFound("num.equals=" + DEFAULT_NUM);

        // Get all the emergencyList where num equals to UPDATED_NUM
        defaultEmergencyShouldNotBeFound("num.equals=" + UPDATED_NUM);
    }

    @Test
    @Transactional
    public void getAllEmergenciesByNumIsInShouldWork() throws Exception {
        // Initialize the database
        emergencyRepository.saveAndFlush(emergency);

        // Get all the emergencyList where num in DEFAULT_NUM or UPDATED_NUM
        defaultEmergencyShouldBeFound("num.in=" + DEFAULT_NUM + "," + UPDATED_NUM);

        // Get all the emergencyList where num equals to UPDATED_NUM
        defaultEmergencyShouldNotBeFound("num.in=" + UPDATED_NUM);
    }

    @Test
    @Transactional
    public void getAllEmergenciesByNumIsNullOrNotNull() throws Exception {
        // Initialize the database
        emergencyRepository.saveAndFlush(emergency);

        // Get all the emergencyList where num is not null
        defaultEmergencyShouldBeFound("num.specified=true");

        // Get all the emergencyList where num is null
        defaultEmergencyShouldNotBeFound("num.specified=false");
    }
    /**
     * Executes the search, and checks that the default entity is returned
     */
    private void defaultEmergencyShouldBeFound(String filter) throws Exception {
        restEmergencyMockMvc.perform(get("/api/emergencies?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(emergency.getId().intValue())))
            .andExpect(jsonPath("$.[*].num").value(hasItem(DEFAULT_NUM.toString())));
    }

    /**
     * Executes the search, and checks that the default entity is not returned
     */
    private void defaultEmergencyShouldNotBeFound(String filter) throws Exception {
        restEmergencyMockMvc.perform(get("/api/emergencies?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @Transactional
    public void getNonExistingEmergency() throws Exception {
        // Get the emergency
        restEmergencyMockMvc.perform(get("/api/emergencies/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEmergency() throws Exception {
        // Initialize the database
        emergencyRepository.saveAndFlush(emergency);

        int databaseSizeBeforeUpdate = emergencyRepository.findAll().size();

        // Update the emergency
        Emergency updatedEmergency = emergencyRepository.findById(emergency.getId()).get();
        // Disconnect from session so that the updates on updatedEmergency are not directly saved in db
        em.detach(updatedEmergency);
        updatedEmergency
            .num(UPDATED_NUM);
        EmergencyDTO emergencyDTO = emergencyMapper.toDto(updatedEmergency);

        restEmergencyMockMvc.perform(put("/api/emergencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emergencyDTO)))
            .andExpect(status().isOk());

        // Validate the Emergency in the database
        List<Emergency> emergencyList = emergencyRepository.findAll();
        assertThat(emergencyList).hasSize(databaseSizeBeforeUpdate);
        Emergency testEmergency = emergencyList.get(emergencyList.size() - 1);
        assertThat(testEmergency.getNum()).isEqualTo(UPDATED_NUM);
    }

    @Test
    @Transactional
    public void updateNonExistingEmergency() throws Exception {
        int databaseSizeBeforeUpdate = emergencyRepository.findAll().size();

        // Create the Emergency
        EmergencyDTO emergencyDTO = emergencyMapper.toDto(emergency);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restEmergencyMockMvc.perform(put("/api/emergencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(emergencyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Emergency in the database
        List<Emergency> emergencyList = emergencyRepository.findAll();
        assertThat(emergencyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteEmergency() throws Exception {
        // Initialize the database
        emergencyRepository.saveAndFlush(emergency);

        int databaseSizeBeforeDelete = emergencyRepository.findAll().size();

        // Get the emergency
        restEmergencyMockMvc.perform(delete("/api/emergencies/{id}", emergency.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Emergency> emergencyList = emergencyRepository.findAll();
        assertThat(emergencyList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Emergency.class);
        Emergency emergency1 = new Emergency();
        emergency1.setId(1L);
        Emergency emergency2 = new Emergency();
        emergency2.setId(emergency1.getId());
        assertThat(emergency1).isEqualTo(emergency2);
        emergency2.setId(2L);
        assertThat(emergency1).isNotEqualTo(emergency2);
        emergency1.setId(null);
        assertThat(emergency1).isNotEqualTo(emergency2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmergencyDTO.class);
        EmergencyDTO emergencyDTO1 = new EmergencyDTO();
        emergencyDTO1.setId(1L);
        EmergencyDTO emergencyDTO2 = new EmergencyDTO();
        assertThat(emergencyDTO1).isNotEqualTo(emergencyDTO2);
        emergencyDTO2.setId(emergencyDTO1.getId());
        assertThat(emergencyDTO1).isEqualTo(emergencyDTO2);
        emergencyDTO2.setId(2L);
        assertThat(emergencyDTO1).isNotEqualTo(emergencyDTO2);
        emergencyDTO1.setId(null);
        assertThat(emergencyDTO1).isNotEqualTo(emergencyDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(emergencyMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(emergencyMapper.fromId(null)).isNull();
    }
}
