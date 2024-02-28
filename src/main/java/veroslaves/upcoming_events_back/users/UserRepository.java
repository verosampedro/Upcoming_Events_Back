package veroslaves.upcoming_events_back.users;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    

    // public UserDetails findByEmail(String email);

    public Optional<User> findByEmail(String email);
    
}
