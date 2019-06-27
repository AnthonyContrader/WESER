package it.contrader.web.rest;

import it.contrader.Micro1App;

import it.contrader.domain.Device;
import it.contrader.repository.DeviceRepository;
import it.contrader.service.DeviceService;
import it.contrader.service.dto.DeviceDTO;
import it.contrader.service.mapper.DeviceMapper;
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
 * Test class for the DeviceResource REST controller.
 *
 * @see DeviceResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Micro1App.class)
public class DeviceResourceIntTest {

    private static final String DEFAULT_DEVTYPE = "AAAAAAAAAA";
    private static final String UPDATED_DEVTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCR = "AAAAAAAAAA";
    private static final String UPDATED_DESCR = "BBBBBBBBBB";

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

    @Autowired
    private DeviceRepository deviceRepository;


    @Autowired
    private DeviceMapper deviceMapper;
    

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restDeviceMockMvc;

    private Device device;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DeviceResource deviceResource = new DeviceResource(deviceService);
        this.restDeviceMockMvc = MockMvcBuilders.standaloneSetup(deviceResource)
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
    public static Device createEntity(EntityManager em) {
        Device device = new Device()
            .devtype(DEFAULT_DEVTYPE)
            .descr(DEFAULT_DESCR)
            .mp(DEFAULT_MP)
            .mpr(DEFAULT_MPR)
            .mc(DEFAULT_MC)
            .mci(DEFAULT_MCI)
            .mb(DEFAULT_MB)
            .mbr(DEFAULT_MBR)
            .mt(DEFAULT_MT)
            .mte(DEFAULT_MTE);
        return device;
    }

    @Before
    public void initTest() {
        device = createEntity(em);
    }

    @Test
    @Transactional
    public void createDevice() throws Exception {
        int databaseSizeBeforeCreate = deviceRepository.findAll().size();

        // Create the Device
        DeviceDTO deviceDTO = deviceMapper.toDto(device);
        restDeviceMockMvc.perform(post("/api/devices")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(deviceDTO)))
            .andExpect(status().isCreated());

        // Validate the Device in the database
        List<Device> deviceList = deviceRepository.findAll();
        assertThat(deviceList).hasSize(databaseSizeBeforeCreate + 1);
        Device testDevice = deviceList.get(deviceList.size() - 1);
        assertThat(testDevice.getDevtype()).isEqualTo(DEFAULT_DEVTYPE);
        assertThat(testDevice.getDescr()).isEqualTo(DEFAULT_DESCR);
        assertThat(testDevice.getMp()).isEqualTo(DEFAULT_MP);
        assertThat(testDevice.getMpr()).isEqualTo(DEFAULT_MPR);
        assertThat(testDevice.getMc()).isEqualTo(DEFAULT_MC);
        assertThat(testDevice.getMci()).isEqualTo(DEFAULT_MCI);
        assertThat(testDevice.getMb()).isEqualTo(DEFAULT_MB);
        assertThat(testDevice.getMbr()).isEqualTo(DEFAULT_MBR);
        assertThat(testDevice.getMt()).isEqualTo(DEFAULT_MT);
        assertThat(testDevice.getMte()).isEqualTo(DEFAULT_MTE);
    }

    @Test
    @Transactional
    public void createDeviceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = deviceRepository.findAll().size();

        // Create the Device with an existing ID
        device.setId(1L);
        DeviceDTO deviceDTO = deviceMapper.toDto(device);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDeviceMockMvc.perform(post("/api/devices")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(deviceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Device in the database
        List<Device> deviceList = deviceRepository.findAll();
        assertThat(deviceList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllDevices() throws Exception {
        // Initialize the database
        deviceRepository.saveAndFlush(device);

        // Get all the deviceList
        restDeviceMockMvc.perform(get("/api/devices?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(device.getId().intValue())))
            .andExpect(jsonPath("$.[*].devtype").value(hasItem(DEFAULT_DEVTYPE.toString())))
            .andExpect(jsonPath("$.[*].descr").value(hasItem(DEFAULT_DESCR.toString())))
            .andExpect(jsonPath("$.[*].mp").value(hasItem(DEFAULT_MP)))
            .andExpect(jsonPath("$.[*].mpr").value(hasItem(DEFAULT_MPR)))
            .andExpect(jsonPath("$.[*].mc").value(hasItem(DEFAULT_MC)))
            .andExpect(jsonPath("$.[*].mci").value(hasItem(DEFAULT_MCI)))
            .andExpect(jsonPath("$.[*].mb").value(hasItem(DEFAULT_MB)))
            .andExpect(jsonPath("$.[*].mbr").value(hasItem(DEFAULT_MBR)))
            .andExpect(jsonPath("$.[*].mt").value(hasItem(DEFAULT_MT.doubleValue())))
            .andExpect(jsonPath("$.[*].mte").value(hasItem(DEFAULT_MTE.doubleValue())));
    }
    

    @Test
    @Transactional
    public void getDevice() throws Exception {
        // Initialize the database
        deviceRepository.saveAndFlush(device);

        // Get the device
        restDeviceMockMvc.perform(get("/api/devices/{id}", device.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(device.getId().intValue()))
            .andExpect(jsonPath("$.devtype").value(DEFAULT_DEVTYPE.toString()))
            .andExpect(jsonPath("$.descr").value(DEFAULT_DESCR.toString()))
            .andExpect(jsonPath("$.mp").value(DEFAULT_MP))
            .andExpect(jsonPath("$.mpr").value(DEFAULT_MPR))
            .andExpect(jsonPath("$.mc").value(DEFAULT_MC))
            .andExpect(jsonPath("$.mci").value(DEFAULT_MCI))
            .andExpect(jsonPath("$.mb").value(DEFAULT_MB))
            .andExpect(jsonPath("$.mbr").value(DEFAULT_MBR))
            .andExpect(jsonPath("$.mt").value(DEFAULT_MT.doubleValue()))
            .andExpect(jsonPath("$.mte").value(DEFAULT_MTE.doubleValue()));
    }
    @Test
    @Transactional
    public void getNonExistingDevice() throws Exception {
        // Get the device
        restDeviceMockMvc.perform(get("/api/devices/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDevice() throws Exception {
        // Initialize the database
        deviceRepository.saveAndFlush(device);

        int databaseSizeBeforeUpdate = deviceRepository.findAll().size();

        // Update the device
        Device updatedDevice = deviceRepository.findById(device.getId()).get();
        // Disconnect from session so that the updates on updatedDevice are not directly saved in db
        em.detach(updatedDevice);
        updatedDevice
            .devtype(UPDATED_DEVTYPE)
            .descr(UPDATED_DESCR)
            .mp(UPDATED_MP)
            .mpr(UPDATED_MPR)
            .mc(UPDATED_MC)
            .mci(UPDATED_MCI)
            .mb(UPDATED_MB)
            .mbr(UPDATED_MBR)
            .mt(UPDATED_MT)
            .mte(UPDATED_MTE);
        DeviceDTO deviceDTO = deviceMapper.toDto(updatedDevice);

        restDeviceMockMvc.perform(put("/api/devices")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(deviceDTO)))
            .andExpect(status().isOk());

        // Validate the Device in the database
        List<Device> deviceList = deviceRepository.findAll();
        assertThat(deviceList).hasSize(databaseSizeBeforeUpdate);
        Device testDevice = deviceList.get(deviceList.size() - 1);
        assertThat(testDevice.getDevtype()).isEqualTo(UPDATED_DEVTYPE);
        assertThat(testDevice.getDescr()).isEqualTo(UPDATED_DESCR);
        assertThat(testDevice.getMp()).isEqualTo(UPDATED_MP);
        assertThat(testDevice.getMpr()).isEqualTo(UPDATED_MPR);
        assertThat(testDevice.getMc()).isEqualTo(UPDATED_MC);
        assertThat(testDevice.getMci()).isEqualTo(UPDATED_MCI);
        assertThat(testDevice.getMb()).isEqualTo(UPDATED_MB);
        assertThat(testDevice.getMbr()).isEqualTo(UPDATED_MBR);
        assertThat(testDevice.getMt()).isEqualTo(UPDATED_MT);
        assertThat(testDevice.getMte()).isEqualTo(UPDATED_MTE);
    }

    @Test
    @Transactional
    public void updateNonExistingDevice() throws Exception {
        int databaseSizeBeforeUpdate = deviceRepository.findAll().size();

        // Create the Device
        DeviceDTO deviceDTO = deviceMapper.toDto(device);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restDeviceMockMvc.perform(put("/api/devices")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(deviceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Device in the database
        List<Device> deviceList = deviceRepository.findAll();
        assertThat(deviceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDevice() throws Exception {
        // Initialize the database
        deviceRepository.saveAndFlush(device);

        int databaseSizeBeforeDelete = deviceRepository.findAll().size();

        // Get the device
        restDeviceMockMvc.perform(delete("/api/devices/{id}", device.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Device> deviceList = deviceRepository.findAll();
        assertThat(deviceList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Device.class);
        Device device1 = new Device();
        device1.setId(1L);
        Device device2 = new Device();
        device2.setId(device1.getId());
        assertThat(device1).isEqualTo(device2);
        device2.setId(2L);
        assertThat(device1).isNotEqualTo(device2);
        device1.setId(null);
        assertThat(device1).isNotEqualTo(device2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DeviceDTO.class);
        DeviceDTO deviceDTO1 = new DeviceDTO();
        deviceDTO1.setId(1L);
        DeviceDTO deviceDTO2 = new DeviceDTO();
        assertThat(deviceDTO1).isNotEqualTo(deviceDTO2);
        deviceDTO2.setId(deviceDTO1.getId());
        assertThat(deviceDTO1).isEqualTo(deviceDTO2);
        deviceDTO2.setId(2L);
        assertThat(deviceDTO1).isNotEqualTo(deviceDTO2);
        deviceDTO1.setId(null);
        assertThat(deviceDTO1).isNotEqualTo(deviceDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(deviceMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(deviceMapper.fromId(null)).isNull();
    }
}
