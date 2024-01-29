package David.Hotel.Models;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
    public class ReservationRequestModel {

    private final String roomNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startDateTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endDateTime;


    public ReservationRequestModel(String roomNumber, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.roomNumber = roomNumber;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
