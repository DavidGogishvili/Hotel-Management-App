package David.Hotel.Services;

import David.Hotel.Entities.Guests;
import David.Hotel.Models.GuestCreateModel;
import David.Hotel.Repositories.GuestDocumentsRepo;
import David.Hotel.Repositories.GuestsRepo;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;


@Service
public class GuestServiceImpl implements GuestService {

    private final GuestsRepo guestsRepo;
    private final GuestDocumentsRepo guestDocumentsRepo;

    public GuestServiceImpl(GuestsRepo guestsRepo, GuestDocumentsRepo guestDocumentsRepo) {
        this.guestsRepo = guestsRepo;
        this.guestDocumentsRepo = guestDocumentsRepo;
    }



    @Override
    public Guests createGuest(GuestCreateModel guestCreateModel) {
        Guests guests = new Guests();
        guests.setName(guestCreateModel.name());
        guests.setLastName(guestCreateModel.lastName());
        guests.setPhoneNumber(guestCreateModel.lastName());
        guests.setEmail(guestCreateModel.email());
        guests.setBirthDate(guestCreateModel.birthDate());
        Integer age = getAge(guestCreateModel.birthDate());
        guests.setAge(age);
        guests.setGender(guestCreateModel.gender());
        guests.setCitizenship(guestCreateModel.citizenship());
        guestsRepo.save(guests);
        return guests;
    }

    private Integer getAge(LocalDate birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
        return null;
    }


}
