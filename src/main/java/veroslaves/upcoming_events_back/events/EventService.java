package veroslaves.upcoming_events_back.events;

import java.util.List;

import org.springframework.stereotype.Service;

import veroslaves.upcoming_events_back.cities.City;
import veroslaves.upcoming_events_back.cities.CityRepository;
import veroslaves.upcoming_events_back.interfaces.IGenericFullService;

@Service
public class EventService implements IGenericFullService <Event> {
    
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

    /* public Event getByEvent_title(String title) throws Exception {
        Event event = eventRepository.findByEvent_title(title).orElseThrow(() -> new EventNotFoundException("Event not found"));

        return event;
    } */

    public Event save(Event event){
        City city = cityRepository.findByNameOfCity(event.getCityName()).orElse(new City(event.getCityName()));
        cityRepository.save(city);

        event.setCity(city);
       
        eventRepository.save(event);
        return event;
    }


}
