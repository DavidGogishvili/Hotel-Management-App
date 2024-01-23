package David.Hotel.Services;

import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationCreateModel;

import java.util.List;

public interface ReservationService {

    Reservations createBooking(ReservationCreateModel reservationCreateModel);


    List<Reservations> findBookings ();

    Reservations getBooking (Integer roomNumber);

}
