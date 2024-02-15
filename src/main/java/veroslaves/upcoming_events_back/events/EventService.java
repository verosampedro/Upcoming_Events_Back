package veroslaves.upcoming_events_back.events;

import java.util.List;

import org.springframework.stereotype.Service;

import veroslaves.upcoming_events_back.interfaces.IGenericFullService;

@Service
public class EventService implements IGenericFullService <Event> {
    
    EventRepository eventRepository;

    

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;

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

    public Event save(Event newEvent){
       
        eventRepository.save(newEvent);
        return newEvent;
    }


}
