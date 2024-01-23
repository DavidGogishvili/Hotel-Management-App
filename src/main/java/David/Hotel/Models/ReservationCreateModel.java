package David.Hotel.Models;

import java.time.LocalDateTime;

public record ReservationCreateModel(

        Integer bookNumber,

        Integer roomNumber,

        LocalDateTime bookedAt,

        LocalDateTime bookedTill,

        Integer bookedBy,

        String bookedFrom,

        String price,

        String promotion,

        String promotionalPrice


) {
}
