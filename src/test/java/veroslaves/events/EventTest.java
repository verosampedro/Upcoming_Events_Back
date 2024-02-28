package veroslaves.events;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import veroslaves.upcoming_events_back.cities.City;
import veroslaves.upcoming_events_back.cities.CityRepository;
import veroslaves.upcoming_events_back.events.Event;
import veroslaves.upcoming_events_back.events.EventNotFoundException;
import veroslaves.upcoming_events_back.events.EventRepository;
import veroslaves.upcoming_events_back.events.EventService;

public class EventTest {

    private EventService eventService;
    private EventRepository eventRepositoryMock;
    private CityRepository cityRepositoryMock;
    private Event event;

    @BeforeEach
    void setUp() throws ParseException {
        eventRepositoryMock = mock(EventRepository.class);
        cityRepositoryMock = mock(CityRepository.class);
        eventService = new EventService(eventRepositoryMock, cityRepositoryMock);

        City eventCity = new City();
        eventCity.setNameOfCity("Gijón");

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String startDateString = "2022/12/23 12:50:00";
        String finishDateString = "2022/12/25 12:50:00";
        Date eventStart = format.parse(startDateString);
        Date eventEnd = format.parse(finishDateString);

        event = new Event("Danzas al aire libre", eventStart, eventEnd, null, 10L, "Muy interesante. Pero muy, muy...", eventCity, null, finishDateString);
        event.setId(1L);
    }

    @Test
    void testEventHas8Attributes() {
        Field[] fields = event.getClass().getDeclaredFields();
        assertThat(fields.length, is(10));
    }

    @Test
    void testEventHasTitleStartDateFinishDateImageMaxParticipantsDescriptionAndCity() {
        assertThat(event.getId(), is(1L));
        assertThat(event.getEvent_title(), is("Danzas al aire libre"));
        assertThat(event.getEvent_image(), is(nullValue()));
        assertThat(event.getMax_participants(), is(10L));
        assertThat(event.getDescription(), is("Muy interesante. Pero muy, muy..."));
    }

    @Test
    void testDeleteEvent() throws Exception {
        // Arrange
        when(eventRepositoryMock.existsById(1L)).thenReturn(true);

        // Delete
        eventService.deleteById(1L);

        // Check
        verify(eventRepositoryMock, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteNonExistingEvent() {
        // Arrange
        when(eventRepositoryMock.existsById(1L)).thenReturn(false);

        // Expected Exception
        assertThrows(EventNotFoundException.class, () -> eventService.deleteById(1L));
    }

}
