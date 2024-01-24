package David.Hotel.Models;

import java.time.LocalDate;

public record GuestCreateModel(
        String name,

        String lastName,

        String phoneNumber,

        Integer personalNumber,

        String email,

        LocalDate birthDate,

        String gender,

        Boolean isGeorgian,

        String passportNumber,

        String citizenship



) {
}
