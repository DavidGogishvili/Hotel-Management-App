package David.Hotel.Models;

import java.time.LocalDate;

public record GuestAndDocumentCreateModel(

         String name,
         String lastName,
         String phoneNumber,
         String email,
         LocalDate birthDate,
         String gender,
         String citizenship,
         String passportNumber,
         LocalDate passportExpDate,
         String privateNumber,
         LocalDate idExpDate,
         String residenceNumber,
         LocalDate residenceExpDate,
         String temporaryDisplacedNumber,
         LocalDate temporaryDisplacedExpDate,
         String drivingLicenceNumber,
         LocalDate drivingLicenceExpDate,
         String permanent

) {
}
