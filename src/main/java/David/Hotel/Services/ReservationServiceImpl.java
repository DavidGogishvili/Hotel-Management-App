package David.Hotel.Services;

import David.Hotel.Entities.GuestDocuments;
import David.Hotel.Entities.Reservations;
import David.Hotel.Models.DocumentCreateModel;
import David.Hotel.Models.ReservationCreateModel;
import David.Hotel.Repositories.GuestDocumentsRepo;
import David.Hotel.Repositories.ReservationsRepo;
import David.Hotel.Repositories.RoomsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationsRepo reservationsRepo;
    private final RoomsRepo roomsRepo;
    private final GuestDocumentsRepo guestDocumentsRepo;


    public ReservationServiceImpl(ReservationsRepo reservationsRepo, RoomsRepo roomsRepo, GuestDocumentsRepo guestDocumentsRepo) {
        this.reservationsRepo = reservationsRepo;
        this.roomsRepo = roomsRepo;
        this.guestDocumentsRepo = guestDocumentsRepo;
    }



    @Override
    public Reservations createBooking(ReservationCreateModel reservationCreateModel) {
        Integer roomNumber = reservationCreateModel.roomNumber();
        LocalDateTime startDateTime = reservationCreateModel.startDateTime();
        LocalDateTime endDateTime = reservationCreateModel.endDateTime();
        if (!roomsRepo.existsByRoomNumber(roomNumber.toString())) {
            throw new RuntimeException("არა ბრტ, სხვა ნომერი გინდა");
        }
        List<Reservations> exitingReservations = reservationsRepo.findBookingsInDateRange
                (roomNumber.toString(), startDateTime, endDateTime);
        if (!exitingReservations.isEmpty()) {
            throw new RuntimeException("ოთახი აღნიშნულ ვადებში უკვე დაჯავშნილია.");
        } else {
        Reservations reservations = new Reservations();
        reservations.setRoomNumber(String.valueOf(reservationCreateModel.roomNumber()));
        reservations.setBookedAt(reservationCreateModel.startDateTime());
        reservations.setBookedTill(reservationCreateModel.endDateTime());
        reservations.setBookedBy(reservationCreateModel.bookedBy());
        reservations.setBookedFrom(reservationCreateModel.bookedFrom());
        reservations.setBookNumber(generateRandom5DigitNumber());

        String roomCategory = roomsRepo.findRoomCategoryByRoomNumber(roomNumber.toString());
        if (roomCategory !=null) {
            switch (roomCategory) {
                case "standard 1 bed" -> reservations.setPrice(100.0);
                case "standard 2 bed" -> reservations.setPrice(200.0);
                case "standard 3 bed" -> reservations.setPrice(300.0);
                case "lux" -> reservations.setPrice(1000.0);
            }
        }
            reservations.setPromotion(Double.valueOf(reservationCreateModel.promotion()));
            reservations.setTax(0.18);
            reservations.setPrice(reservations.getPrice() + (reservations.getPrice() * reservations.getTax()));
            reservations.setPromotionalPrice(reservations.getPrice() - reservations.getPrice()* reservations.getPromotion());
            long days = ChronoUnit.DAYS.between(reservations.getBookedAt(), reservations.getBookedTill());
            reservations.setBooked(String.valueOf(days));
            reservationsRepo.save(reservations);
        return reservations;
    }
}




    private Integer generateRandom5DigitNumber() {
        Random random = new Random();
            return 10000 + random.nextInt(90000);
    }

    @Override
    public String isRoomBookedInDateRange(String roomNumber, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<Reservations> existingReservations = reservationsRepo.findBookingsInDateRange(
                roomNumber, startDateTime, endDateTime);
        if (!roomsRepo.existsByRoomNumber(roomNumber)) {
            throw new RuntimeException("არასწორ ნომერს ეძებ ძმა, ეგეთი არ გვაქვს");
        }
        if (!existingReservations.isEmpty()) {
            return "ოთახი აღნიშნულ ვადებში დაჯავშნილია.";
        } else {
            return "ოთახი აღნიშნულ ვადებში თავისუფალია.";
        }
    }

    @Override
    public Reservations getReservations(Integer bookNumber) {
        List<Reservations> reservationsList = reservationsRepo.findAllByBookNumber(bookNumber);
        if (reservationsList.isEmpty()) {
            return null;
        }
        return reservationsList.getFirst();
}
    @Override
    public GuestDocuments createDocument(DocumentCreateModel documentCreateModel) {
        GuestDocuments guestDocuments = new GuestDocuments();
        guestDocuments.setPassportNumber(documentCreateModel.passportNumber());
        guestDocuments.setPassportExpDate(documentCreateModel.passportExpDate());
        guestDocuments.setPrivateNumber(documentCreateModel.privateNumber());
        guestDocuments.setIdExpDate(documentCreateModel.idExpDate());
        guestDocuments.setResidenceNumber(documentCreateModel.residenceNumber());
        guestDocuments.setResidenceExpDate(documentCreateModel.residenceExpDate());
        guestDocuments.setTemporaryDisplacedNumber(documentCreateModel.temporaryDisplacedNumber());
        guestDocuments.setTemporaryDisplacedExpDate(documentCreateModel.temporaryDisplacedExpDate());
        guestDocuments.setDrivingLicenceNumber(documentCreateModel.drivingLicenceNumber());
        guestDocuments.setDrivingLicenceExpDate(documentCreateModel.drivingLicenceExpDate());
        guestDocuments.setPermanent(documentCreateModel.permanent());
        guestDocumentsRepo.save(guestDocuments);
        checkDocumentExpiry(guestDocuments);
        return guestDocuments;    }

    private void checkDocumentExpiry(GuestDocuments guestDocuments) {
        checkDocumentExpiration(guestDocuments.getPassportExpDate(), "Passport");
        checkDocumentExpiration(guestDocuments.getIdExpDate(), "ID");
        checkDocumentExpiration(guestDocuments.getDrivingLicenceExpDate(), "Diving Licence" );
        checkDocumentExpiration(guestDocuments.getResidenceExpDate(), "Certificate Of Residence");
        checkDocumentExpiration(guestDocuments.getTemporaryDisplacedExpDate(), "Temporary Certificate Of Displaced Person");
    }

    private void checkDocumentExpiration(LocalDate expirationDate, String documentType) {
        if (isDocumentExpired(expirationDate)) {
            throw new RuntimeException(documentType + " ვადაგასულია ძმაუ");
        }
    }

    private boolean isDocumentExpired(LocalDate expirationDate) {
        return expirationDate != null && expirationDate.isBefore(LocalDate.now());
    }

}

