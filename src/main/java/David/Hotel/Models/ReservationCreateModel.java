package David.Hotel.Models;

import java.time.LocalDateTime;

public record ReservationCreateModel(

        Integer roomNumber,

        LocalDateTime startDateTime,

        LocalDateTime endDateTime,

        Integer bookedBy,

        String bookedFrom,

        String promotion

) {
}
