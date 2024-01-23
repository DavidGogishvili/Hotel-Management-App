package David.Hotel.Controllers;


import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationCreateModel;
import David.Hotel.Services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bookings")
public class ReservationController {

    private final ReservationService reservationService;


    @PostMapping("/new")
    public Reservations createBooking(@RequestBody ReservationCreateModel reservationCreateModel) {
        return reservationService.createBooking(reservationCreateModel);
    }


    @GetMapping("/find")
    public List <Reservations> findBookings () {
    return reservationService.findBookings();
    }


    @GetMapping("/find/number/{roomNumber}")
    public Reservations bookings (@PathVariable Integer roomNumber) {
        return reservationService.getBooking(roomNumber);
    }
}
