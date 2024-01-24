package David.Hotel.Services;

import David.Hotel.Entities.Guests;
import David.Hotel.Models.GuestCreateModel;
import David.Hotel.Repositories.GuestsRepo;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestsRepo guestsRepo;

    public GuestServiceImpl(GuestsRepo guestsRepo) {
        this.guestsRepo = guestsRepo;
    }


    @Override
    public Guests createGuest(GuestCreateModel guestCreateModel) {
        Guests guests = new Guests();
        guests.setName(guestCreateModel.name());
        guests.setLastName(guestCreateModel.lastName());
        guests.setPersonalNumber(guestCreateModel.personalNumber());
        guests.setEmail(guestCreateModel.email());
        guests.setPhoneNumber(guestCreateModel.phoneNumber());
        guests.setBirthDate(guestCreateModel.birthDate());
        guests.setGender(guestCreateModel.gender());
        guests.setIsGeorgian(guestCreateModel.isGeorgian());
        guests.setCitizenship(guestCreateModel.citizenship());
        guests.setPassportNumber(guestCreateModel.passportNumber());
        guestsRepo.save(guests);
        return guests;

    }

    @Override
    public Guests findAllByPersonalNumber(Integer personalNumber) {
        return guestsRepo.findAllByPersonalNumber(personalNumber).orElseThrow();
    }
}
