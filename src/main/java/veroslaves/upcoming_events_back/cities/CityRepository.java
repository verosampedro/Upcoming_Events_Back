package veroslaves.upcoming_events_back.cities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    public Optional<City> findByNameOfCity(String city);
}
