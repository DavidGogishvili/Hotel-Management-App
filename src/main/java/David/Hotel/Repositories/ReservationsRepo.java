    package David.Hotel.Repositories;

    import David.Hotel.Entities.Reservations;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    import java.time.LocalDateTime;
    import java.util.List;

    public interface ReservationsRepo extends JpaRepository <Reservations, Integer> {


        @Query(value = "SELECT t.* FROM Reservations t WHERE room_number = :roomNumber " +
                "AND ((booked_at BETWEEN :startDateTime AND :endDateTime) " +
                "OR (booked_till BETWEEN :startDateTime AND :endDateTime))", nativeQuery = true)
        List<Reservations> findBookingsInDateRange(@Param("roomNumber") String roomNumber,
                                                   @Param("startDateTime") LocalDateTime startDateTime,
                                                   @Param("endDateTime") LocalDateTime endDateTime);
    }



