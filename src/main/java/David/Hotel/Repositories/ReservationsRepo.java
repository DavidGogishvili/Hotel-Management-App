    package David.Hotel.Repositories;

    import David.Hotel.Entities.Reservations;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    import java.time.LocalDateTime;
    import java.util.List;

    public interface ReservationsRepo extends JpaRepository <Reservations, Integer> {


        List <Reservations> findAllByBookNumber(Integer bookNumber);

        @Query(value = "SELECT t FROM Reservations t WHERE t.roomNumber = :roomNumber " +
                "AND ((t.bookedAt BETWEEN :startDateTime AND :endDateTime) " +
                "OR (t.bookedTill BETWEEN :startDateTime AND :endDateTime))")
        List<Reservations> findBookingsInDateRange(@Param("roomNumber") String roomNumber,
                                                   @Param("startDateTime") LocalDateTime startDateTime,
                                                   @Param("endDateTime") LocalDateTime endDateTime);


    }



