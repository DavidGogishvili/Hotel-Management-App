package David.Hotel.Repositories;

import David.Hotel.Entities.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationsRepo extends JpaRepository <Reservations, Integer> {


    @Query(value = "SELECT t.* FROM bookings t WHERE room_number = :roomNumber " +
            "AND ((booked_at > :startDateTime AND booked_at < :endDateTime) " +
            "OR (booked_till > :startDateTime AND booked_till < :endDateTime)) LIMIT 501", nativeQuery = true)
    List<Reservations> findBookingsInDateRange(@Param("roomNumber") String roomNumber,
                                          @Param("startDateTime") LocalDateTime startDateTime,
                                          @Param("endDateTime") LocalDateTime endDateTime);
    }



