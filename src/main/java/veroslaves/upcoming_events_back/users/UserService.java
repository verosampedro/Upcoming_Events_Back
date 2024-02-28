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
import veroslaves.upcoming_events_back.exceptions.EventParticipantsLimitException;
import veroslaves.upcoming_events_back.exceptions.UserNotFoundException;

@Service
public class UserService {

    UserRepository repository;
    EventRepository eventRepository;

    public UserService(UserRepository repository, EventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }


    public List<User> getAll(){
         List<User> users = repository.findAll();
         return users;
    }


    public User getById(Long id) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        
        return user;
    }

    public User save(@NonNull User user) {
        User newUser = user;

        repository.save(newUser);
        return newUser;
    }

    public User updateUserEvents(Long eventId) throws Exception {
        
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();

        User updatingUser = repository.findByEmail(auth.getName()).orElseThrow(() -> new UserNotFoundException("User not found"));
        Event newEvent = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Event not found"));

        Set<Event> userEvents = updatingUser.getEvents();

        if (!userEvents.contains(newEvent) && newEvent.getUsers().size() < newEvent.getMax_participants()) {
            userEvents.add(newEvent);
            System.out.println(newEvent.getUsers());
        } else if (userEvents.contains(newEvent)) {
            userEvents.remove(newEvent);
        } else {
            throw new EventParticipantsLimitException("Event max participants limit is exceeded");
        }
            
        
        updatingUser.setEvents(userEvents);

        User updatedUser = repository.save(updatingUser);
        
        return updatedUser;
    }

}
