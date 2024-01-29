package David.Hotel.Services;

import David.Hotel.Entities.Reservations;
import David.Hotel.Models.ReservationCreateModel;
import David.Hotel.Repositories.ReservationsRepo;
import David.Hotel.Repositories.RoomsRepo;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationsRepo reservationsRepo;
    private final RoomsRepo roomsRepo;


    public ReservationServiceImpl(ReservationsRepo reservationsRepo,RoomsRepo roomsRepo) {
        this.reservationsRepo = reservationsRepo;
        this.roomsRepo = roomsRepo;
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
        reservations.setBookNumber(reservationCreateModel.bookNumber());
        reservations.setRoomNumber(String.valueOf(reservationCreateModel.roomNumber()));
        reservations.setBookedAt(reservationCreateModel.startDateTime());
        reservations.setBookedTill(reservationCreateModel.endDateTime());
        reservations.setBookedBy(reservationCreateModel.bookedBy());
        reservations.setBookedFrom(reservationCreateModel.bookedFrom());
        String roomCategory = roomsRepo.findRoomCategoryByRoomNumber(roomNumber.toString());
          if ("standard 1 bed".equals(roomCategory)) {
                reservations.setPrice(100.0);
          } else if ("standard 2 bed".equals(roomCategory)) {
              reservations.setPrice(200.0);
          } else if ("standard 3 bed".equals(roomCategory)) {
              reservations.setPrice(300.0);
          } else if ("lux".equals(roomCategory)) {
                reservations.setPrice(1000.0);
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


}

