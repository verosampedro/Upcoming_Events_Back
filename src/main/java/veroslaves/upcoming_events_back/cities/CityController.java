package veroslaves.upcoming_events_back.cities;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import veroslaves.upcoming_events_back.interfaces.IGenericLimitedService;

@RestController
@RequestMapping(path = "${api-endpoint}/cities")
public class CityController {

    IGenericLimitedService<City> service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<City> index(){
       List<City> cities = service.getAll();
        return cities;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>("City deleted successfully", HttpStatus.OK);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
