package David.Hotel.Services;

import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationCreateModel;

import java.time.LocalDateTime;

public interface ReservationService {

    String isRoomBookedInDateRange(String roomNumber, LocalDateTime startDateTime, LocalDateTime endDateTime);



    Reservations createBooking(ReservationCreateModel reservationCreateModel);









}
