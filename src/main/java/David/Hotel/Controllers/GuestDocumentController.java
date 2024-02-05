package David.Hotel.Controllers;

import David.Hotel.Entities.GuestDocuments;
import David.Hotel.Entities.Guests;
import David.Hotel.Models.GuestAndDocumentCreateModel;
import David.Hotel.Services.GuestDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("GuestWithDocument")
public class GuestDocumentController {

    private final GuestDocumentService guestDocumentService;

    @PostMapping("/create")
    public ResponseEntity<Guests> createGuestAndDocument(@RequestBody GuestAndDocumentCreateModel requestModel) {
        Guests createdGuest = guestDocumentService.createGuestAndDocument(requestModel);
        return new ResponseEntity<>(createdGuest, HttpStatus.CREATED);
    }


    @GetMapping("/find/{id}")
    public List <GuestDocuments> searchGuestWithDocuments(@PathVariable Integer id) {
        return guestDocumentService.getGuestWithDocument(id);
    }

    @GetMapping("/find")
    public List <GuestDocuments> findAllGuestWithDocuments () {
        return guestDocumentService.findAllGuestWithDocuments();
    }
}
