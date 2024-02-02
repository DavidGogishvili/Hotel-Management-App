package David.Hotel.Controllers;

import David.Hotel.Entities.GuestDocuments;
import David.Hotel.Entities.Guests;
import David.Hotel.Models.DocumentCreateModel;
import David.Hotel.Models.GuestCreateModel;
import David.Hotel.Repositories.GuestsRepo;
import David.Hotel.Services.GuestService;
import David.Hotel.Services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestsRepo guestsRepo;
    private final GuestService guestService;
    private final ReservationService reservationService;


    @PostMapping("/create")
    public Guests createGuest (@RequestBody GuestCreateModel guestsCreateModel) {
        return guestService.createGuest(guestsCreateModel);

    }
    @GetMapping("/find")
    public List <Guests> findGuests () {
        return guestsRepo.findAll();
    }




    @PostMapping("/document")
    public ResponseEntity<?> createDocument(@RequestBody DocumentCreateModel documentCreateModel) {
        try {
            GuestDocuments createGuestDocuments = reservationService.createDocument(documentCreateModel);
            return new ResponseEntity<>(createGuestDocuments, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
