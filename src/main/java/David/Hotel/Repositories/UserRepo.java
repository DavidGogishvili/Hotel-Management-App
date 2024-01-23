package David.Hotel.Repositories;

import David.Hotel.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findAllByEmail(String email);

}
