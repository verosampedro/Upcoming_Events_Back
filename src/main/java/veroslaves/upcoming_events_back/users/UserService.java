package veroslaves.upcoming_events_back.users;

import java.util.List;

import org.springframework.stereotype.Service;

import veroslaves.upcoming_events_back.Exceptions.UserNotFoundException;

@Service
public class UserService {
    UserRepository repository;


    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public List<User> getAll(){
         List<User> users = repository.findAll();
         return users;
    }


    public User getById(Long id) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        
        return user;
    }

    

}
