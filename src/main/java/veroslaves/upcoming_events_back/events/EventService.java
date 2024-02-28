package veroslaves.upcoming_events_back.events;

import java.util.List;

import org.springframework.stereotype.Service;

import veroslaves.upcoming_events_back.cities.City;
import veroslaves.upcoming_events_back.cities.CityRepository;
import veroslaves.upcoming_events_back.interfaces.IGenericFullService;

@Service
public class EventService implements IGenericFullService<Event> {
    
    EventRepository eventRepository;
    CityRepository cityRepository;

    public EventService(EventRepository eventRepository, CityRepository cityRepository) {
        this.eventRepository = eventRepository;
        this.cityRepository = cityRepository;
    }

    public List<Event> getAll() {
        List<Event> events = eventRepository.findAll();
        return events;
    }

    public Event getById(Long id) throws Exception {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found"));
        return event;
    }

    public Event save(Event event) {
        City city = cityRepository.findByNameOfCity(event.getCityName()).orElse(new City(event.getCityName()));
        cityRepository.save(city);
        event.setCity(city);
        eventRepository.save(event);
        return event;
    }

    public Event update(Long id, Event event) throws Exception {
        Event updatingEvent = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found"));

        City city = cityRepository.findByNameOfCity(event.getCityName()).orElse(new City(event.getCityName()));
        cityRepository.save(city);

        updatingEvent.setId(event.getId());
        updatingEvent.setEvent_title(event.getEvent_title());
        updatingEvent.setStart_date(event.getStart_date());
        updatingEvent.setFinish_date(event.getFinish_date());
        updatingEvent.setEvent_image(event.getEvent_image());
        updatingEvent.setMax_participants(event.getMax_participants());
        updatingEvent.setDescription(event.getDescription());
        updatingEvent.setCity(city);
        Event updatedEvent = eventRepository.save(updatingEvent);
        return updatedEvent;
    }

    public void deleteById(Long id) throws Exception {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        } else {
            throw new EventNotFoundException("Event not found");
        }
    }
}
