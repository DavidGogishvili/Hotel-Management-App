package David.Hotel.Services;

import David.Hotel.Entities.Guests;
import David.Hotel.Models.GuestCreateModel;
import David.Hotel.Repositories.GuestsRepo;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;


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
        if (!guestsRepo.existsByPersonalNumber(guestCreateModel.phoneNumber())) {
            throw new RuntimeException("სტუმარი უკვე რეგისტრირებულია სისტემაში");
        }
        guests.setEmail(guestCreateModel.email());
        guests.setPhoneNumber(guestCreateModel.phoneNumber());
        guests.setBirthDate(guestCreateModel.birthDate());
        guests.setGender(guestCreateModel.gender());
        guests.setIsGeorgian(guestCreateModel.isGeorgian());
        guests.setCitizenship(guestCreateModel.citizenship());
        guests.setPassportNumber(guestCreateModel.passportNumber());
        guests.setAge(getAge(guestCreateModel.birthDate()));
        guestsRepo.save(guests);
        return guests;

    }


    private Integer getAge(LocalDate birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
        return null;
    }

    @Override
    public Guests findAllByPersonalNumber(String personalNumber) {
        return guestsRepo.findAllByPersonalNumber(personalNumber).orElseThrow();
    }
}
