package veroslaves.upcoming_events_back.users;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    // public Optional<User> findByUserEmail(String email);
    
}
