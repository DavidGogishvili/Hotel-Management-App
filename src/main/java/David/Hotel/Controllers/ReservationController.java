package David.Hotel.Controllers;


import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationRequestModel;
import David.Hotel.Models.ReservationCreateModel;
import David.Hotel.Repositories.ReservationsRepo;
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


    @PostMapping("/isRoomReserved")
    public String isRoomBookedInDateRange(@RequestBody ReservationRequestModel request) {
        return reservationService.isRoomBookedInDateRange(request.getRoomNumber(),
                request.getStartDateTime(), request.getEndDateTime());
    }

    @GetMapping("/{bookNumber}")
    public Reservations reservations (@PathVariable Integer bookNumber) {
        return reservationService.getReservations(bookNumber);
    }

}
