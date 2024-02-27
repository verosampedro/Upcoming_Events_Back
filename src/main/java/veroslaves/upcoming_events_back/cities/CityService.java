package veroslaves.upcoming_events_back.cities;

import java.util.List;

import org.springframework.stereotype.Service;

import veroslaves.upcoming_events_back.interfaces.IGenericLimitedService;

@Service
public class CityService implements IGenericLimitedService<City> {

    CityRepository repository;

   

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> getAll() {
        List<City> cities = repository.findAll();

        return cities;
        
    }

    public City getById(Long id) throws Exception {
        City city = repository.findById(id).orElseThrow(() -> new CityNotFoundException("City not found"));

        return city;
    }

    public void deleteById(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new CityNotFoundException("City not found");
        }
    }

    @Override
    public City save(City obj) {
        
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
