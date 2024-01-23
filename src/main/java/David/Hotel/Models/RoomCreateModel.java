package David.Hotel.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RoomCreateModel(
        String roomNumber,

        String beds,

        String standardRoom,

        String available,

        Double priceForNight,

        Integer floor

) {
}
