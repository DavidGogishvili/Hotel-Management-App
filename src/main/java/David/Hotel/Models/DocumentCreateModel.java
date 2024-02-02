package David.Hotel.Models;

import java.time.LocalDate;

public record DocumentCreateModel(
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
