package veroslaves.upcoming_events_back.cities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason =  "City not found")
public class CityNotFoundException extends Exception{

    public CityNotFoundException(String message){
        super(message);
    }

    public CityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
