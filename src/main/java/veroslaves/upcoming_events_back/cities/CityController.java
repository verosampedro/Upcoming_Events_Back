package veroslaves.upcoming_events_back.cities;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import veroslaves.upcoming_events_back.interfaces.IGenericFullService;

@RestController
@RequestMapping(path = "${api-endpoint}/cities")
public class CityController {

    IGenericFullService<City> service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<City> index(){
       List<City> cities = service.getAll();
        return cities;
    }

}
