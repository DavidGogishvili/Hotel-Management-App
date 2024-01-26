package David.Hotel.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ReservationCreateModel(

        Integer bookNumber,

        Integer roomNumber,

        LocalDateTime startDateTime,

        LocalDateTime endDateTime,

        Integer bookedBy,

        String bookedFrom,

        String price,

        String promotion,

        String promotionalPrice


) {
}
