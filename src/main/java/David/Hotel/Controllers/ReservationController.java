package David.Hotel.Controllers;


import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationRequestModel;
import David.Hotel.Models.ReservationCreateModel;
import David.Hotel.Repositories.ReservationsRepo;
import David.Hotel.Repositories.RoomsRepo;
import David.Hotel.Services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bookings")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationsRepo reservationsRepo;
    private final RoomsRepo roomsRepo;




    @PostMapping("/new")
    public ResponseEntity<?> createBooking(@RequestBody ReservationCreateModel reservationCreateModel) {
        try {
            Reservations createdReservation = reservationService.createBooking(reservationCreateModel);
            return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find")
    public List <Reservations> findBookings () {
    return reservationsRepo.findAll();
    }


    @PostMapping("/isRoomBooked")
    public String isRoomBookedInDateRange(@RequestBody ReservationRequestModel request) {
        return reservationService.isRoomBookedInDateRange(request.getRoomNumber(),
                request.getStartDateTime(), request.getEndDateTime());
    }


}
