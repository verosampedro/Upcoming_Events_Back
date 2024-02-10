package veroslaves.upcoming_events_back.users;

import java.util.List;
import java.util.Set;

import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import veroslaves.upcoming_events_back.events.Event;
import veroslaves.upcoming_events_back.events.EventNotFoundException;
import veroslaves.upcoming_events_back.events.EventRepository;
import veroslaves.upcoming_events_back.exceptions.UserNotFoundException;

@Service
public class UserService {
    UserRepository repository;
    EventRepository eventRepository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public List<User> getAll(){
         List<User> users = repository.findAll();
         return users;
    }


    public User getById(Long id) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        
        return user;
    }

    public User save(@NonNull User type) {
        User newUser = new User();

        repository.save(newUser);
        return newUser;
    }

    public User addEventToUser(Long eventId) throws Exception {
        
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();

        User updatingUser = repository.findByEmail(auth.getName()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Event newEvent = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Event not found"));

        Set<Event> userEvents = updatingUser.getEvents();
        userEvents.add(newEvent);
        
        updatingUser.setEvents(userEvents);

        User updatedUser = repository.save(updatingUser);
        
        return updatedUser;
    }

}
