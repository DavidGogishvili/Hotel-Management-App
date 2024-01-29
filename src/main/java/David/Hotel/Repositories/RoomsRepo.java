package David.Hotel.Repositories;

import David.Hotel.Entities.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface RoomsRepo extends JpaRepository <Rooms, Integer> {
    boolean existsByRoomNumber(String roomNumber);

    @Query("SELECT r.category FROM Rooms r WHERE r.roomNumber = :roomNumber")
    String findRoomCategoryByRoomNumber(String roomNumber);



}
