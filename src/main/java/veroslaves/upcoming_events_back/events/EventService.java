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

    public Event update(Long id, Event event) throws Exception {
        
        Event updatingEvent = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found"));
        
        updatingEvent.setId(event.getId());
        updatingEvent.setEvent_title(event.getEvent_title());
        updatingEvent.setStart_date(event.getStart_date());
        updatingEvent.setFinish_date(event.getFinish_date());
        updatingEvent.setEvent_image(event.getEvent_image());
        updatingEvent.setMax_participants(event.getMax_participants());
        updatingEvent.setDescription(event.getDescription());
        updatingEvent.setCity(event.getCity());

        Event updatedEvent = eventRepository.save(updatingEvent);
        
        return updatedEvent;
    }
}
