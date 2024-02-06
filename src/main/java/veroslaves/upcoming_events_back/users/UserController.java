package veroslaves.upcoming_events_back.users;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getOneById(@PathVariable("id")Long id) throws Exception {
        User user = service.getById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(user);
    }
    
}
