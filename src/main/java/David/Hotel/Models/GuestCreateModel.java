package David.Hotel.Models;

import java.time.LocalDate;

public record GuestCreateModel(
        String name,

        String lastName,

        String phoneNumber,

        String email,

        LocalDate birthDate,

        String gender,

        String citizenship,

        String identification



) {

}
