package veroslaves.upcoming_events_back.events;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import veroslaves.upcoming_events_back.interfaces.IGenericFullService;

@RestController
@RequestMapping(path = "${api-endpoint}/events")
public class EventController {
    
    IGenericFullService<Event> service;

    public EventController(IGenericFullService<Event> service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Event> index() {
        List<Event> events = service.getAll();
        return events;
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Event> getOneById(@PathVariable("id") Long id) throws Exception {
        Event event = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(event);
    }

    @PostMapping(path = "")
    public ResponseEntity<Event> create(@RequestBody Event event) {
        Event newEvent = service.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEvent);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(@PathVariable("id") Long id, @RequestBody Event event) throws Exception {
        Event updatedEvent = service.update(id, event);
        return ResponseEntity.status(HttpStatus.OK).body(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Event deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}
