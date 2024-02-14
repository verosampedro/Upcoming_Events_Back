package veroslaves.upcoming_events_back.events;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long>{

    public Optional<Event>findByName(String event_tittle);

}
