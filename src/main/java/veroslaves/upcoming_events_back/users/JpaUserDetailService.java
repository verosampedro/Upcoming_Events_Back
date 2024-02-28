package veroslaves.upcoming_events_back.users;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailService implements UserDetailsService{

    UserRepository repository;

    public JpaUserDetailService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return repository
        
            .findByEmail(email)
            .map(SecurityUser::new)
            .orElseThrow(()-> new UsernameNotFoundException("User not found" + email));

    }

    
    
}
