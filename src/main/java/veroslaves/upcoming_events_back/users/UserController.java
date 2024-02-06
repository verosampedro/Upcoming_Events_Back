package veroslaves.upcoming_events_back.users;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api-endpoint}/users")
public class UserController {

    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<User> index() {
        List<User> users = service.getAll();
        return users;
    }
    
}
