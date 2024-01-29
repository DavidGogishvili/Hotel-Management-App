package David.Hotel.Services;

import David.Hotel.Entities.Guests;
import David.Hotel.Models.GuestCreateModel;

public interface GuestService {

    Guests createGuest (GuestCreateModel guestCreateModel);

    Guests findAllByPersonalNumber(String personalNumber);
}
