package veroslaves.cities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import veroslaves.upcoming_events_back.cities.City;
import veroslaves.upcoming_events_back.cities.CityController;
import veroslaves.upcoming_events_back.cities.CityNotFoundException;
import veroslaves.upcoming_events_back.cities.CityService;

public class CityTest {

    private CityController cityController;
    private CityService cityServiceMock;

    @BeforeEach
    void setUp() {
        cityServiceMock = mock(CityService.class);
        cityController = new CityController(cityServiceMock);
    }

    @Test
    void testGetAllCities() {
        // Arrange
        List<City> cities = new ArrayList<>();
        cities.add(new City("City 1"));
        cities.add(new City("City 2"));
        when(cityServiceMock.getAll()).thenReturn(cities);

        // Act
        List<City> result = cityController.index();

        // Assert
        assertEquals(cities, result);
    }

    @Test
    void testDeleteCity_Success() throws Exception {
        // Arrange
        Long cityId = 1L;

        // Delete
        ResponseEntity<String> response = cityController.deleteCity(cityId);

        // Check
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("City deleted successfully", response.getBody());
        verify(cityServiceMock).deleteById(cityId);
    }

    @Test
    void testDeleteCity_NotFound() throws Exception {
        // Arrange
        Long cityId = 1L;
        doThrow(new CityNotFoundException("City not found")).when(cityServiceMock).deleteById(cityId);

        // Try to Delete non existing City
        ResponseEntity<String> response = cityController.deleteCity(cityId);

        // Check
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("City not found", response.getBody());
        verify(cityServiceMock).deleteById(cityId);
    }
  }