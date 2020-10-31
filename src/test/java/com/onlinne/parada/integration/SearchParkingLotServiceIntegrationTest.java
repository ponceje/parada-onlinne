package com.onlinne.parada.integration;

import com.onlinne.parada.repository.LocationRepository;
import com.onlinne.parada.repository.ParkingLotRepository;
import com.onlinne.parada.repository.ParkingPositionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SearchParkingLotServiceIntegrationTest {

    public static final String PARADA_URI = "/parada";

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ParkingPositionRepository parkingPositionRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_parking_lot_list_when_search_given_location_name() throws Exception {
        //given
        String locationName = "Glorietta1";

        //when
        //then
        mockMvc.perform(get(PARADA_URI+"/search/"+locationName))
                .andExpect(jsonPath("$[0].parkingLotId").isNumber())
                .andExpect(jsonPath("$[0].parkingLotCode").isString())
                .andExpect(jsonPath("$[0].locationId").isNumber()
                );
    }
}
