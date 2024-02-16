package veroslaves.upcoming_events_back.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Event max participants limit is exceeded")
public class EventParticipantsLimitException extends Exception {

    public EventParticipantsLimitException(String message) {
    super(message);
    }

public EventParticipantsLimitException(String message, Throwable cause) {
    super(message, cause);
    }
}