package David.Hotel.Repositories;

import David.Hotel.Entities.Guests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestsRepo extends JpaRepository <Guests, Integer> {

}
