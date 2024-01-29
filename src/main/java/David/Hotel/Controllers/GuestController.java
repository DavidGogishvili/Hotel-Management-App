package David.Hotel.Controllers;

import David.Hotel.Entities.Guests;
import David.Hotel.Models.GuestCreateModel;
import David.Hotel.Repositories.GuestsRepo;
import David.Hotel.Services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestsRepo guestsRepo;
    private final GuestService guestService;


    @PostMapping("/create")
    public Guests createGuest (@RequestBody GuestCreateModel guestsCreateModel) {
        return guestService.createGuest(guestsCreateModel);
    }
    @GetMapping("/find")
    public List <Guests> findGuests () {
        return guestsRepo.findAll();
    }

    @GetMapping("/find/{personalNumber}")
    public Guests guest (@PathVariable String personalNumber) {
        return guestService.findAllByPersonalNumber(personalNumber);
    }
}
