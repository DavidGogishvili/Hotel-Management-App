package David.Hotel.Controllers;


import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationRequestModel;
import David.Hotel.Models.ReservationCreateModel;
import David.Hotel.Repositories.ReservationsRepo;
import David.Hotel.Services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bookings")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationsRepo reservationsRepo;

    @PostMapping("/new")
    public Reservations createBooking(@RequestBody ReservationCreateModel reservationCreateModel) {
        return reservationService.createBooking(reservationCreateModel);
    }


    @GetMapping("/find")
    public List <Reservations> findBookings () {
    return reservationsRepo.findAll();
    }


    @PostMapping("/isRoomBooked")
    public String isRoomBookedInDateRange(@RequestBody ReservationRequestModel request) {
        return reservationService.isRoomBookedInDateRange(request.getRoomNumber(), request.getStartDateTime(), request.getEndDateTime());
    }


}
