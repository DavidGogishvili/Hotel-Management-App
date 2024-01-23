package David.Hotel.Repositories;

import David.Hotel.Entities.Rooms;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RoomsRepo extends JpaRepository <Rooms, Integer> {

   }
