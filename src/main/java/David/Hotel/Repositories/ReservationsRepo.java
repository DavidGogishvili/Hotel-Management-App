package David.Hotel.Repositories;

import David.Hotel.Entities.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationsRepo extends JpaRepository <Reservations, Integer> {

    Optional <Reservations> findAllByRoomNumber(String roomNumber);
}
