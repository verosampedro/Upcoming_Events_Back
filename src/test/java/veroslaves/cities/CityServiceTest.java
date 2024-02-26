package veroslaves.cities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import veroslaves.upcoming_events_back.cities.City;
import veroslaves.upcoming_events_back.cities.CityNotFoundException;
import veroslaves.upcoming_events_back.cities.CityRepository;
import veroslaves.upcoming_events_back.cities.CityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAll_ReturnsAllCities() {
        // Arrange
        List<City> cities = new ArrayList<>();
        cities.add(new City("City 1"));
        cities.add(new City("City 2"));
        when(cityRepository.findAll()).thenReturn(cities);

        // Act
        List<City> result = cityService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(cityRepository).findAll();
    }

    @Test
    public void getById_ExistingId_ReturnsCity() throws Exception {
        // Arrange
        Long cityId = 1L;
        City city = new City("City 1"); 
        when(cityRepository.findById(cityId)).thenReturn(Optional.of(city));

        // Act
        City result = cityService.getById(cityId);

        // Assert
        assertNotNull(result);
        verify(cityRepository).findById(cityId);
    }

    @Test
    public void getById_NonExistingId_ThrowsException() {
        // Arrange
        Long cityId = 1L;
        when(cityRepository.findById(cityId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CityNotFoundException.class, () -> {
            cityService.getById(cityId);
        });
    }

    @Test
    public void deleteById_ExistingId_DeletesCity() throws Exception {
        // Arrange
        Long cityId = 1L;
        when(cityRepository.existsById(cityId)).thenReturn(true);

        // Act
        cityService.deleteById(cityId);

        // Assert
        verify(cityRepository).deleteById(cityId);
    }

    @Test
    public void deleteById_NonExistingId_ThrowsException() {
        // Arrange
        Long cityId = 1L;
        when(cityRepository.existsById(cityId)).thenReturn(false);

        // Act & Assert
        assertThrows(CityNotFoundException.class, () -> {
            cityService.deleteById(cityId);
        });
    }

}
